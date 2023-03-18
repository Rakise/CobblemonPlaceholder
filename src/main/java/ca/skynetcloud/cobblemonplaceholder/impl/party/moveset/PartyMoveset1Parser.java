package ca.skynetcloud.cobblemonplaceholder.impl.party.moveset;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PartyMoveset1Parser extends PartyParser {

    public PartyMoveset1Parser() {
        super(0);
    }

    protected PartyMoveset1Parser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
            return "party_" + this.slot + "_one"+ "_moveset";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new PartyMoveset1Parser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon pokemon, String[] p2) {
        return Text.capitalize(Objects.requireNonNull(pokemon.getMoveSet().get(0)).getName());
    }
}
