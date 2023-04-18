package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.Cobblemonplaceholder;
import org.bukkit.event.Event;
import java.util.List;

public class VictoryEvent extends Event {

    private final List<BattleActor> winners;

    public VictoryEvent(List<BattleActor> winners) {
        this.winners = winners;
    }

    public List<BattleActor> getWinners() {
        return winners;
    }
}
