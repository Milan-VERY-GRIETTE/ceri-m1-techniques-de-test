package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IRocketFactoryTest {

    IPokemonFactory rocketFactory = new RocketPokemonFactory();
    Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 1, 1, 1, 1, 0);

    @BeforeEach
    public void setUp() {}

    @Test
    public void shouldGetPokemon() throws PokedexException {
        Pokemon bulbasaur = rocketFactory.createPokemon(0,1,1,1,1);

        assertEquals(bulbasaur.getIndex(), pokemon.getIndex());
        assertEquals(bulbasaur.getCp(), pokemon.getCp());
        assertEquals(bulbasaur.getHp(), pokemon.getHp());
        assertEquals(bulbasaur.getDust(), pokemon.getDust());
        assertEquals(bulbasaur.getCandy(), pokemon.getCandy());
        assertEquals(bulbasaur.getName(), pokemon.getName());
        assertEquals(bulbasaur.getAttack(), pokemon.getAttack());
        assertEquals(bulbasaur.getDefense(), pokemon.getDefense());
        assertEquals(bulbasaur.getStamina(), pokemon.getStamina());
        assertEquals(50, pokemon.getIv(), 50);
    }

    @Test
    public void shouldThrowPokedexExceptionWhenIndexTooLow() {
        assertThrows(PokedexException.class,() -> rocketFactory.createPokemon(-1,1,1,1,1));
    }

    @Test
    public void shouldThrowPokedexExceptionWhenIndexTooHigh() {
        assertThrows(PokedexException.class,() -> rocketFactory.createPokemon(151,1,1,1,1));
    }

}