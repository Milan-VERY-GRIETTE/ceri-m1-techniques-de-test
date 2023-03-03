package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokedex pokedex = pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
    PokemonTrainer pokemonTrainer = new PokemonTrainer("Trainer", Team.INSTINCT, pokedex);

    @Before
    public void setUp() {
        Mockito.when(pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void shouldGetTrainer() {
        assertEquals(pokemonTrainer, pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory));
    }

}