package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
    Pokemon pokemon = new Pokemon(0, "Pokemon", 1, 1, 1, 1, 1, 1, 1, 0);

    @BeforeEach
    public void setUp() {
        Mockito.when(pokemonFactory.createPokemon(anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenAnswer(mockData ->  {
            int index = mockData.getArgument(0);
            if(index < 0 || index > 150) {
                throw new PokedexException("Invalid index");
            }
            return pokemon;
        });
    }

    @Test
    public void shouldGetPokemon() {
        assertEquals(pokemon, pokemonFactory.createPokemon(0,1,1,1,1));
    }

    @Test
    public void shouldThrowPokedexExceptionWhenIndexTooLow() {
        assertThrows(PokedexException.class,() -> pokemonFactory.createPokemon(-1,1,1,1,1));
    }

    @Test
    public void shouldThrowPokedexExceptionWhenIndexTooHigh() {
        assertThrows(PokedexException.class,() -> pokemonFactory.createPokemon(151,1,1,1,1));
    }

}