package ca.skynetcloud.cobblemonplaceholder;

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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Cobblemonplaceholder extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("teste");
        CobblemonEvents.INSTANCE.getBattleVictory().subscribe(Priority.NORMAL, winevent -> {
            List<BattleActor> winners = winevent.getWinners();
            System.out.println("Sending message to console...");
            Bukkit.getConsoleSender().sendMessage("winner: " + winners.get(0).getName());
            return null;
        });
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            System.out.println("PlaceholderAPI not found, disabling CobblemonPlaceholder.");
            this.getServer().getPluginManager().disablePlugin((Plugin)this);
        }
        else {
            new CobblemonExpansion(this).register();
        }
    }

}
