package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider metadataProvider = PokemonMetadataProvider.getInstance();
    PokemonMetadata bulbasaurMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata vaporeonMetadata = new PokemonMetadata(133,"Aquali",186,168,260);

    @BeforeEach
    public void setUp() {}

    @Test
    public void shouldGetBulbasaurMetadata() {
        try {
            PokemonMetadata testMetaData = metadataProvider.getPokemonMetadata(0);
            assertEquals(bulbasaurMetadata.getIndex(), testMetaData.getIndex());
            assertEquals(bulbasaurMetadata.getName(), testMetaData.getName());
            assertEquals(bulbasaurMetadata.getAttack(), testMetaData.getAttack());
            assertEquals(bulbasaurMetadata.getDefense(), testMetaData.getDefense());
            assertEquals(bulbasaurMetadata.getStamina(), testMetaData.getStamina());
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetVaporeonMetadata() {
        try {
            PokemonMetadata testMetaData = metadataProvider.getPokemonMetadata(133);
            assertEquals(vaporeonMetadata.getIndex(), testMetaData.getIndex());
            assertEquals(vaporeonMetadata.getName(), testMetaData.getName());
            assertEquals(vaporeonMetadata.getAttack(), testMetaData.getAttack());
            assertEquals(vaporeonMetadata.getDefense(), testMetaData.getDefense());
            assertEquals(vaporeonMetadata.getStamina(), testMetaData.getStamina());
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }

}