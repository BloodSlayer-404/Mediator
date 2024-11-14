package org.example;

public class PokemonCenter implements PokemonCenterMediator{

    private PokePC pokePC = new PokePC();

    @Override
    public String requestHealing(Trainer trainer) {
        return "Pokémon Center: Healing Pokémon from " + trainer.getName() +
                "\n" + trainer.getName() + " now has all his Pokémon in perfect condition.";
    }

    @Override
    public String requestPotionPurchase(Trainer trainer, int amount) {
        return "Pokémon Center: " + trainer.getName() + " has bought " + amount + " potions.";
    }

    @Override
    public String requestInfo(Trainer trainer) {
        return "Pokémon Center: Providing information to " + trainer.getName() +
                "\nInformation of the day: Train your Pokémon with love and patience!";
    }

    @Override
    public String requestTeamManagement(Trainer trainer, Pokemon pokemon, boolean add) {
        return add ? pokePC.storePokemon(trainer, pokemon) : pokePC.retrievePokemon(trainer, pokemon);
    }

    @Override
    public String requestPokemonTrade(Trainer trainer1, Pokemon pokemon1, Trainer trainer2, Pokemon pokemon2) {
        trainer1.removePokemon(pokemon1);
        trainer2.addPokemon(pokemon1);
        trainer2.removePokemon(pokemon2);
        trainer1.addPokemon(pokemon2);
        return "Pokémon Center: Carrying out exchange between " + trainer1.getName() + " and " + trainer2.getName() +
                "\nExchange completed: " + trainer1.getName() + " now has a " + pokemon2.getName() +
                " and " + trainer2.getName() + " now has a " + pokemon1.getName();
    }
}
