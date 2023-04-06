package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;
    private final ArrayList<Pokemon> pokemonList = new ArrayList<>();

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return this.pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
        return this.pokemonList.lastIndexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if(id < 0 || id > pokemonList.size() - 1) {
            throw new PokedexException("Invalid index");
        }
        return pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemonList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        ArrayList<Pokemon> tempPokemonList = new ArrayList<>(pokemonList);
        tempPokemonList.sort(order);
        return tempPokemonList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.metadataProvider.getPokemonMetadata(index);
    }
}
