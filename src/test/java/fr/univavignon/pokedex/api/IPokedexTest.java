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
    PokemonMetadata bulbasaurMetadata = new PokemonMetadata(
            bulbasaur.getIndex(),
            bulbasaur.getName(),
            bulbasaur.getAttack(),
            bulbasaur.getDefense(),
            bulbasaur.getStamina()
    );

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
        pokedex.addPokemon(vaporeon);
        pokedex.addPokemon(bulbasaur);
        List<Pokemon> list = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(bulbasaur.getIndex(), list.get(0).getIndex());
    }
    
    @Test
    public void shouldCreatePokemon() throws PokedexException {
        Pokemon createdBulbasaur = pokedex.createPokemon(0,613, 64,4000, 4);
        assertEquals(bulbasaur.getIndex(), createdBulbasaur.getIndex());
        assertEquals(bulbasaur.getCp(), createdBulbasaur.getCp());
        assertEquals(bulbasaur.getHp(), createdBulbasaur.getHp());
        assertEquals(bulbasaur.getDust(), createdBulbasaur.getDust());
        assertEquals(bulbasaur.getCandy(), createdBulbasaur.getCandy());
        assertEquals(bulbasaur.getName(), createdBulbasaur.getName());
        assertEquals(bulbasaur.getAttack(), createdBulbasaur.getAttack());
        assertEquals(bulbasaur.getDefense(), createdBulbasaur.getDefense());
        assertEquals(bulbasaur.getStamina(), createdBulbasaur.getStamina());
    }

    @Test
    public void shouldPokemonMetadata() throws PokedexException {
        PokemonMetadata createdBulbasaurMetadata = pokedex.getPokemonMetadata(0);
        assertEquals(bulbasaurMetadata.getIndex(), createdBulbasaurMetadata.getIndex());
        assertEquals(bulbasaurMetadata.getName(), createdBulbasaurMetadata.getName());
        assertEquals(bulbasaurMetadata.getAttack(), createdBulbasaurMetadata.getAttack());
        assertEquals(bulbasaurMetadata.getDefense(), createdBulbasaurMetadata.getDefense());
        assertEquals(bulbasaurMetadata.getStamina(), createdBulbasaurMetadata.getStamina());
    }

}