package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    PokemonTrainer pokemonTrainer;

    @BeforeEach
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        IPokemonMetadataProvider metadataProvider = PokemonMetadataProvider.getInstance();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        pokemonTrainer = new PokemonTrainer("Trainer", Team.INSTINCT, pokedex);
    }

    @Test
    public void shouldGetTrainer() {
        PokemonTrainer testTrainer = pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory);

        assertEquals(pokemonTrainer.getName(), testTrainer.getName());
        assertEquals(pokemonTrainer.getTeam(), testTrainer.getTeam());
    }

}