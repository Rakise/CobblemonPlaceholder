package ca.skynetcloud.cobblemonplaceholder.impl.PokemonGet;

import com.cobblemon.mod.common.Cobblemon;
import org.bukkit.Bukkit;
import com.cobblemon.mod.common.api.pokemon.evolution.PreEvolution;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.battles.BattleVictoryEvent;
import java.util.List;
import com.cobblemon.mod.common.pokemon.evolution.CobblemonLazyPreEvolution;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.pokemon.FormData;
import com.cobblemon.mod.common.command.argument.PokemonPropertiesArgumentType;
import com.cobblemon.mod.common.pokemon.Species;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PokemonGet {
    
    public void onWin() {
        CobblemonEvents.BATTLE_VICTORY.subscribe(Priority.NORMAL, winevent -> {
            List<BattleActor> winners = winevent.getWinners();
            List<BattleActor> losers = winevent.losers;
            Bukkit.getConsoleSender().sendMessage("winner: " + winners.get(0).getName());
            return null;
        });
    }
    
    public static Species getPreEvo(Pokemon pokemon) {
        return pokemon.getPreEvolution().getSpecies();
    }

    public static Pokemon pickPokemon(final Player player, int slot) throws NoPokemonStoreException {
        return Cobblemon.INSTANCE.getStorage().getParty(player.getUniqueId()).get(slot - 1);
    }

    public static Pokemon givePokemon(final Player player, Pokemon pokemon) throws NoPokemonStoreException {
        PlayerPartyStore party = Cobblemon.INSTANCE.getStorage().getParty(player.getUniqueId());
        party.add(pokemon);
        return pokemon;
    }
}
