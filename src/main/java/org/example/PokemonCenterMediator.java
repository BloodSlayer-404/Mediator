package org.example;

public interface PokemonCenterMediator {

    /**
     * Request healing for a trainer's Pokémon.
     * @param trainer: The trainer who requests the healing.
     * @return A message indicating the result of the healing.
     */
    String requestHealing(Trainer trainer);

    /**
     * Requests the purchase of potions from a trainer.
     * @param trainer: The trainer who requests the purchase.
     * @param amount: The amount of potions to purchase.
     * @return A message indicating the result of the purchase.
     */
    String requestPotionPurchase(Trainer trainer, int amount);

    /**
     * Provides general information to the coach.
     * @param trainer The coach who requests the information.
     * @return An informative message.
     */
    String requestInfo(Trainer trainer);

    /**
     * Manage your trainer's team on PC by adding or removing Pokémon.
     * @param trainer: The trainer who requests management of the team.
     * @param pokemon: The Pokémon to be stored or retrieved.
     * @param add: If true, the Pokémon is stored; if false, it is retrieved.
     * @return A message indicating the result of the operation.
     */
    String requestTeamManagement(Trainer trainer, Pokemon pokemon, boolean add);

    /**
     * Performs the exchange of Pokémon between two trainers.
     * @param trainer1: The first coach to participate in the exchange.
     * @param pokemon1: The Pokémon that the first trainer provides.
     * @param trainer2: The second coach to participate in the exchange.
     * @param pokemon2: The Pokémon that the second trainer provides.
     * @return A message indicating the result of the exchange.
     */
    String requestPokemonTrade(Trainer trainer1, Pokemon pokemon1, Trainer trainer2, Pokemon pokemon2);
}
