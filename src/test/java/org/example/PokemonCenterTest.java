package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonCenterTest {

    PokemonCenterMediator mediator = new PokemonCenter();
    Trainer ash = new Trainer("Ash", mediator);
    Trainer misty = new Trainer("Misty", mediator);

    /**
     * Test to verify that the healPokemon method correctly requests healing of Pokémon.
     */
    @Test
    void testHealingRequest() {
        String result = ash.healPokemon();
        assertEquals("Ash requests to heal his Pokémon.\n" +
                        "Pokémon Center: Healing Pokémon from Ash\n" +
                        "Ash now has all his Pokémon in perfect condition.",
                result);
    }

    /**
     * Test to verify that the buyPotions method correctly requests the purchase of potions.
     */
    @Test
    void testPotionPurchaseRequest() {
        String result = misty.buyPotions(5);
        assertEquals("Misty request to buy 5 potions.\n" +
                        "Pokémon Center: Misty has bought 5 potions.",
                result);
    }

    /**
     * Test to verify that the getInfo method correctly requests information from the Pokémon Center.
     */
    @Test
    void testInfoRequest() {

        String result = ash.getInfo();
        assertEquals("Ash request information.\n" +
                        "Pokémon Center: Providing information to Ash" +
                        "\nInformation of the day: Train your Pokémon with love and patience!",
                result);
    }

    /**
     * Test to verify that saving and retrieving Pokémon on your PC is working properly.
     */
    @Test
    void testStoreAndRetrievePokemon() {
        Pokemon bulbasaur = new Pokemon("Bulbasaur");
        misty.addPokemon(bulbasaur);

        String storeResult = misty.storePokemon(bulbasaur);
        assertEquals("Misty requests to save a Bulbasaur in the PC.\n" +
                        "PC: Saving the Bulbasaur from Misty",
                storeResult);


        String retrieveResult = misty.retrievePokemon(bulbasaur);
        assertEquals("Misty requests to recover a Bulbasaur from the PC.\n" +
                        "PC: Recovering Bulbasaur to Misty",
                retrieveResult);
    }

    /**
     * Test to verify that trading Pokémon between two trainers is working correctly.
     */
    @Test
    void testPokemonTrade() {
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon starmie = new Pokemon("Starmie");

        ash.addPokemon(pikachu);
        misty.addPokemon(starmie);

        String tradeResult = ash.tradePokemon(pikachu, misty, starmie);

        assertEquals("Ash requests to exchange a Pikachu with Misty for Starmie\n" +
                        "Pokémon Center: Carrying out exchange between Ash and Misty" +
                        "\nExchange completed: Ash now has a Starmie and " +
                        "Misty now has a Pikachu",
                tradeResult);

    }
}