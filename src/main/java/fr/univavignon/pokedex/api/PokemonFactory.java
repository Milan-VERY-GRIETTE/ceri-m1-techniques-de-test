package fr.univavignon.pokedex.api;

/**
 * Implementation of PokemonFactory interface.
 */
public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(
            int index,
            int cp,
            int hp,
            int dust,
            int candy
    ) throws PokedexException {
        PokemonMetadata pokemonMetadata = PokemonMetadataProvider
                .getInstance()
                .getPokemonMetadata(index);

        return new Pokemon(
                index,
                pokemonMetadata.getName(),
                pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                (Math.random() * 100)
        );
    }
}
