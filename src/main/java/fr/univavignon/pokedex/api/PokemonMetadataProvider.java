package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static PokemonMetadataProvider pmpInstance;
    private final ArrayList<PokemonMetadata> pokemonMetadataList = new ArrayList<>();

    private PokemonMetadataProvider() {}

    public static synchronized PokemonMetadataProvider getInstance() {
        if (pmpInstance == null) {
            pmpInstance = new PokemonMetadataProvider();
            pmpInstance.initialize();
        }
        return pmpInstance;
    }

    private void initialize() {
        for (int i = 0; i < 150; i++) {
            if (i == 0) {
                this.pokemonMetadataList.add(new PokemonMetadata(i, "Bulbizzare", 126, 126, 90));
            }
            else if (i == 133) {
                this.pokemonMetadataList.add(new PokemonMetadata(i, "Aquali", 186, 168, 260));
            }
            else {
                this.pokemonMetadataList.add(new PokemonMetadata(i, "MissingNo.", 0, 0, 0));
            }
        }
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index > pokemonMetadataList.size() - 1) {
            throw new PokedexException("Invalid index");
        }
        return pokemonMetadataList.get(index);
    }
}
