package ca.skynetcloud.cobblemonplaceholder.impl.party.moveset;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.util.LocalizationUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.MutableComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PartyMoveset1Parser extends PartyParser {


    private String name;

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
        return pokemon.getMoveSet().getMoves().size() >= 1 ? pokemon.getMoveSet().get(0).getDisplayName().getString() : "Empty";

    }
}
