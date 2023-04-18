package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.Cobblemonplaceholder;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Event;
import com.cobblemon.mod.common.battles.actor.PlayerBattleActor;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import java.util.UUID;
import java.util.ArrayList;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;

public class VictoryEvent extends Event {
    
    private static final HandlerList handlers = new HandlerList();
    private final List<BattleActor> winners;

    public VictoryEvent(List<BattleActor> winners) {
        this.winners = winners;
    }

    public String getWinners() {
        UUID uuid = winners.get(0).getPlayerUUIDs();
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        if (player.getName() == null) {
            return "Unknown player";
        }
        return player.getName();
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
