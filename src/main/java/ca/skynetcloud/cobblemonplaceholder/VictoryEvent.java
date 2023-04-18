package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.Cobblemonplaceholder;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Event;
import java.util.List;
import java.util.ArrayList;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;

public class VictoryEvent extends Event {
    
    private static final HandlerList handlers = new HandlerList();
    private final List<BattleActor> winners;

    public VictoryEvent(List<BattleActor> winners) {
        this.winners = winners;
    }

    public List<BattleActor> getWinners() {
        List<String> names = new ArrayList<>();
        names.add(winners.get(0).getName());
        return names;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
