package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    PokemonMetadata bulbasaurMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata vaporeonMetadata = new PokemonMetadata(133,"Aquali",186,168,260);

    @BeforeEach
    public void setUp() throws PokedexException {
        Mockito.when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaurMetadata);
        Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(vaporeonMetadata);
    }

    @Test
    public void shouldGetBulbasaurMetadata() {
        try {
            PokemonMetadata testMetaData = metadataProvider.getPokemonMetadata(0);
            assertEquals(bulbasaurMetadata, testMetaData);
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetVaporeonMetadata() {
        try {
            PokemonMetadata testMetaData = metadataProvider.getPokemonMetadata(133);
            assertEquals(vaporeonMetadata, testMetaData);
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }

}