package fr.univavignon.pokedex.api;

/**
 * Implementation of PokemonTrainerFactory interface.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(
                PokemonMetadataProvider.getInstance(),
                new PokemonFactory()
        );
        return new PokemonTrainer(name, team, pokedex);
    }
}
