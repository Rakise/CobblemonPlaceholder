package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.Cobblemonplaceholder;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Event;
import com.cobblemon.mod.common.battles.actor.PlayerBattleActor;
import java.util.List;
import java.util.ArrayList;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;

public class VictoryEvent extends Event {
    
    private static final HandlerList handlers = new HandlerList();
    private final List<BattleActor> winners;

    public VictoryEvent(List<BattleActor> winners) {
        this.winners = winners;
    }

    public MutableText getWinners() {
        return winners.get(0).getName();
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
