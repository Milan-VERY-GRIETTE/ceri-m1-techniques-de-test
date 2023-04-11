package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexTest {

    IPokedex pokedex;
    Pokemon bulbasaur = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    Pokemon vaporeon = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

    @BeforeEach
    public void setUp() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokemonMetadataProvider metadataProvider = PokemonMetadataProvider.getInstance();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
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
        ArrayList<Pokemon> refList = new ArrayList<>();
        refList.add(bulbasaur);

        pokedex.addPokemon(bulbasaur);
        List<Pokemon> list = pokedex.getPokemons();
        assertEquals(refList, list);
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