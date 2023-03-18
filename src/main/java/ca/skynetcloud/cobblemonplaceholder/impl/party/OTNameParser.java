package ca.skynetcloud.cobblemonplaceholder.impl.party;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.Objects;

public class OTNameParser extends PartyParser {

    public OTNameParser() {
        super(0);
    }

    protected OTNameParser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
        return "party_ot_" + this.slot + "_name";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new OTNameParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon p1, String[] p2) {

        return p0.getName();
    }
}
