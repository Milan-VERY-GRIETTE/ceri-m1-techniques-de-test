package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonMetadataProvider metadataProvider = PokemonMetadataProvider.getInstance();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void shouldGetPokedex() {
        assertEquals(pokedex.getClass(), pokedexFactory.createPokedex(metadataProvider, pokemonFactory).getClass());
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
    }

}