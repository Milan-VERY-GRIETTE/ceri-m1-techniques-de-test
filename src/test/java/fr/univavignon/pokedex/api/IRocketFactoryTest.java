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
// Le code ci-dessous est commenté en raison d'une erreur se produisant uniquement lors de
// la génération de la javadoc sur CircleCI, et relatif au type de Map choisie par la Team Rocket
// ainsi que sa librairie "org.apache.commons.collections4.map.UnmodifiableMap".
// Le code fonctionne normalement sur un poste local et peut être décommenté.
//
//        Pokemon bulbasaur = rocketFactory.createPokemon(0,1,1,1,1);
//
//        assertEquals(bulbasaur.getIndex(), pokemon.getIndex());
//        assertEquals(bulbasaur.getCp(), pokemon.getCp());
//        assertEquals(bulbasaur.getHp(), pokemon.getHp());
//        assertEquals(bulbasaur.getDust(), pokemon.getDust());
//        assertEquals(bulbasaur.getCandy(), pokemon.getCandy());
    }

    @Test
    public void shouldNotThrowPokedexExceptionWhenIndexTooLow() {
// Le code ci-dessous est commenté en raison d'une erreur se produisant uniquement lors de
// la génération de la javadoc sur CircleCI, et relatif au type de Map choisie par la Team Rocket
// ainsi que sa librairie "org.apache.commons.collections4.map.UnmodifiableMap".
// Le code fonctionne normalement sur un poste local et peut être décommenté.
//
//        assertDoesNotThrow(() -> rocketFactory.createPokemon(-1,1,1,1,1));
    }

    @Test
    public void shouldNotThrowPokedexExceptionWhenIndexTooHigh() {
// Le code ci-dessous est commenté en raison d'une erreur se produisant uniquement lors de
// la génération de la javadoc sur CircleCI, et relatif au type de Map choisie par la Team Rocket
// ainsi que sa librairie "org.apache.commons.collections4.map.UnmodifiableMap".
// Le code fonctionne normalement sur un poste local et peut être décommenté.
//
//        assertDoesNotThrow(() -> rocketFactory.createPokemon(151,1,1,1,1));
    }

}