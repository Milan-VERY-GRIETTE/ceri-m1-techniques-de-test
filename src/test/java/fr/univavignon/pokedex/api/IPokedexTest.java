package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

public class IPokedexTest {

    IPokedex pokedex = Mockito.mock(IPokedex.class);
    Pokemon bulbasaur = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon vaporeon = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    List<Pokemon> pokemonList;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonList = new ArrayList<>();

        // ADD MOCK
        Mockito.when(pokedex.addPokemon(any(Pokemon.class))).thenAnswer(mockData ->  {
            pokemonList.add(mockData.getArgument(0));
            return pokemonList.size() - 1;
        });

        // SIZE MOCK
        Mockito.when(pokedex.size()).thenAnswer(mockData -> pokemonList.size());

        // GET MOCK
        Mockito.when(pokedex.getPokemon(any(Integer.class))).thenAnswer(mockData -> {
            int index = mockData.getArgument(0);
            if(index < 0 || index > pokemonList.size() - 1) {
                throw new PokedexException("Invalid index");
            }
            return pokemonList.get(mockData.getArgument(0));
        });

        // GET ALL MOCK
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);

        // GET ALL AND SORT MOCK
        Mockito.when(pokedex.getPokemons(any())).thenAnswer(mockData -> {
            pokemonList.sort(mockData.getArgument(0));
            return pokemonList;
        });
    }

    @Test
    public void shouldAddPokemon() {
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);
    }

    @Test
    public void shouldGetSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(bulbasaur);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void shouldThrowPokedexExceptionWhenIndexOutOfBounds() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    public void shouldGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbasaur);
        assertEquals(0, pokedex.getPokemon(0).getIndex());
    }

    @Test
    public void shouldGetPokemonList(){
        pokedex.addPokemon(bulbasaur);
        List<Pokemon> list = pokedex.getPokemons();
        assertEquals(pokemonList, list);
    }

    @Test
    public void shouldSortList(){
        Comparator<Pokemon> comparator = (o1, o2) -> {
            if (o1.getIndex() < o2.getIndex()){
                return -1;
            }
            else if (o1.getIndex() == o2.getIndex()) {
                return 0;
            }
            return 0;
        };
        pokedex.addPokemon(vaporeon);
        pokedex.addPokemon(bulbasaur);
        List<Pokemon> list = pokedex.getPokemons(comparator);
        assertEquals(bulbasaur.getIndex(), list.get(0).getIndex());
    }

}