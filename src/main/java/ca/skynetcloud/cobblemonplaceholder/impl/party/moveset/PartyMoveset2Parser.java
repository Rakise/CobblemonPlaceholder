package ca.skynetcloud.cobblemonplaceholder.impl.party.moveset;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PartyMoveset2Parser extends PartyParser {

    public PartyMoveset2Parser() {
        super(0);
    }

    protected PartyMoveset2Parser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
        return "party_" + this.slot + "_two" + "_moveset";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new PartyMoveset2Parser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon pokemon, String[] p2) {
        if (pokemon.getMoveSet().get(1) == null){
            return "N/A";
        }
        return Text.capitalize(Objects.requireNonNull(pokemon.getMoveSet().get(1)).getName());

    }
}
