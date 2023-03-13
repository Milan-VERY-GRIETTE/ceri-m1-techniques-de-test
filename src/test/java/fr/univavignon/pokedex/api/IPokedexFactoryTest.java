package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
    IPokedex pokedex = Mockito.mock(IPokedex.class);

    @BeforeEach
    public void setUp() {
        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void shouldGetPokedex() {
        assertEquals(pokedex, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
    }

}