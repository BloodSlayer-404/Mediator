package org.example;

public class PokePC {

    /**
     * Stores a Pokémon on the PC and removes it from the trainer's team.
     * @param trainer: The trainer who requests to keep the Pokémon.
     * @param pokemon: The Pokémon to be saved.
     * @return A message indicating the storage of the Pokémon.
     */
    public String storePokemon(Trainer trainer, Pokemon pokemon) {
        trainer.removePokemon(pokemon);
        return "PC: Saving the " + pokemon.getName() + " from " + trainer.getName();
    }

    /**
     * Retrieves a Pokémon from the PC and adds it to the trainer's team.
     * @param trainer: The trainer who requests to recover the Pokémon.
     * @param pokemon: The Pokémon that is going to recover.
     * @return A message indicating the Pokémon's recovery.
     */
    public String retrievePokemon(Trainer trainer, Pokemon pokemon) {
        trainer.addPokemon(pokemon);
        return "PC: Recovering " + pokemon.getName() + " to " + trainer.getName();
    }
}
