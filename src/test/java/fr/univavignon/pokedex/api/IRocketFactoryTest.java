package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IRocketFactoryTest {

    IPokemonFactory rocketFactory = new RocketPokemonFactory();
    Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 1, 1, 1, 1, 0);

    @BeforeEach
    public void setUp() {}

    @Test
    public void shouldGetPokemonWithAbnormalStats() throws PokedexException {
        Pokemon bulbasaur = rocketFactory.createPokemon(0,1,1,1,1);

        assertEquals(bulbasaur.getIndex(), pokemon.getIndex());
        assertEquals(bulbasaur.getCp(), pokemon.getCp());
        assertEquals(bulbasaur.getHp(), pokemon.getHp());
        assertEquals(bulbasaur.getDust(), pokemon.getDust());
        assertEquals(bulbasaur.getCandy(), pokemon.getCandy());
    }

    @Test
    public void shouldNotThrowPokedexExceptionWhenIndexTooLow() {
        assertDoesNotThrow(() -> rocketFactory.createPokemon(-1,1,1,1,1));
    }

    @Test
    public void shouldNotThrowPokedexExceptionWhenIndexTooHigh() {
        assertDoesNotThrow(() -> rocketFactory.createPokemon(151,1,1,1,1));
    }

}