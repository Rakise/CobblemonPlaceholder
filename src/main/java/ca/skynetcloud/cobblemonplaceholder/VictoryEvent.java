package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.Cobblemonplaceholder;
import org.bukkit.event.Event;
import java.util.List;
import java.util.Collections;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;

public class VictoryEvent extends Event {

    private final List<BattleActor> winners;

    public VictoryEvent(List<BattleActor> winners) {
        this.winners = winners;
    }

    public List<BattleActor> getWinners() {
        return Collections.singletonList(winners.get(0));
    }
}
