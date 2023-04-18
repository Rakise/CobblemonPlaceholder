package ca.skynetcloud.cobblemonplaceholder;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Cobblemonplaceholder extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("inicializando...");
        CobblemonEvents.INSTANCE.BATTLE_VICTORY.subscribe(Priority.NORMAL, winevent -> {
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
