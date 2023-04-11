package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory = new PokemonFactory();
    Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 1, 1, 1, 1, 0);

    @BeforeEach
    public void setUp() {}

    @Test
    public void shouldGetPokemon() throws PokedexException {
        Pokemon bulbasaur = pokemonFactory.createPokemon(0,1,1,1,1);

        assertEquals(bulbasaur.getIndex(), pokemon.getIndex());
        assertEquals(bulbasaur.getCp(), pokemon.getCp());
        assertEquals(bulbasaur.getHp(), pokemon.getHp());
        assertEquals(bulbasaur.getDust(), pokemon.getDust());
        assertEquals(bulbasaur.getCandy(), pokemon.getCandy());
        assertEquals(bulbasaur.getName(), pokemon.getName());
        assertEquals(bulbasaur.getAttack(), pokemon.getAttack());
        assertEquals(bulbasaur.getDefense(), pokemon.getDefense());
        assertEquals(bulbasaur.getStamina(), pokemon.getStamina());
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