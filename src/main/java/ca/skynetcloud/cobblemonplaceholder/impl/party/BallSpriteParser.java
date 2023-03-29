
package ca.skynetcloud.cobblemonplaceholder.impl.party;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class BallSpriteParser extends PartyParser
{
    public BallSpriteParser() {
        super(0);
    }

    protected BallSpriteParser(final int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ball";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new BallSpriteParser(i));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getCaughtBall().getName().getPath();
    }
}
