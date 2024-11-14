package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Trainer {

    @Getter
    private final String name;
    private List<Pokemon> team = new ArrayList<>();
    private final PokemonCenterMediator mediator;

    /**
     * Adds a Pokémon to the trainer's team.
     * @param pokemon: The Pokémon that is added to the team.
     * @return A message indicating that the Pokémon has been added.
     */
    public String addPokemon(Pokemon pokemon) {
        team.add(pokemon);
        return name + " has added a " + pokemon.getName() + " to his team.";
    }

    /**
     * Removes a Pokémon from the trainer's team.
     * @param pokemon: The Pokémon that is removed from the team.
     * @return A message indicating that the Pokémon has been eliminated.
     */
    public String removePokemon(Pokemon pokemon) {
        team.remove(pokemon);
        return name + " has eliminated a " + pokemon.getName() + " of his team.";
    }

    /**
     * Request healing of the trainer's Pokémon at the Pokémon Center.
     * @return A message indicating the result of the healing.
     */
    public String healPokemon() {
        return name + " requests to heal his Pokémon.\n" + mediator.requestHealing(this);
    }

    /**
     * Request potions to be purchased at the Pokémon Center.
     * @param amount: The amount of potions to purchase.
     * @return A message indicating the result of the purchase.
     */
    public String buyPotions(int amount) {
        return name + " request to buy " + amount + " potions.\n" + mediator.requestPotionPurchase(this, amount);
    }

    /**
     * Ask for information at the Pokémon Center.
     * @return An informative message.
     */
    public String getInfo() {
        return name + " request information.\n" + mediator.requestInfo(this);
    }

    /**
     * Request to store a Pokémon in the Pokémon Center PC.
     * @param pokemon: The Pokémon to be stored.
     * @return A message indicating the storage of the Pokémon.
     */
    public String storePokemon(Pokemon pokemon) {
        return name + " requests to save a " + pokemon.getName() + " in the PC.\n" + mediator.requestTeamManagement(this, pokemon, true);
    }

    /**
     * Request to retrieve a Pokémon from the Pokémon Center PC.
     * @param pokemon: The Pokémon that is going to recover.
     * @return A message indicating the Pokémon's recovery.
     */
    public String retrievePokemon(Pokemon pokemon) {
        return name + " requests to recover a " + pokemon.getName() + " from the PC.\n" + mediator.requestTeamManagement(this, pokemon, false);
    }

    /**
     * Request to trade Pokémon with another trainer.
     * @param myPokemon: The current trainer's Pokémon being traded.
     * @param otherTrainer: The other trainer participating in the exchange.
     * @param otherPokemon: The other trainer's Pokémon being traded.
     * @return A message indicating the result of the exchange.
     */
    public String tradePokemon(Pokemon myPokemon, Trainer otherTrainer, Pokemon otherPokemon) {
        return name + " requests to exchange a " + myPokemon.getName() + " with " + otherTrainer.getName() + " for " + otherPokemon.getName() +
                "\n" + mediator.requestPokemonTrade(this, myPokemon, otherTrainer, otherPokemon);
    }
}
