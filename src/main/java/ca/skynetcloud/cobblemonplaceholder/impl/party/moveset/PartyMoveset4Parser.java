package ca.skynetcloud.cobblemonplaceholder.impl.party.moveset;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.moves.MoveSet;
import com.cobblemon.mod.common.api.moves.MoveTemplate;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.PokemonStats;
import com.cobblemon.mod.common.util.LocalizationUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class PartyMoveset4Parser extends PartyParser {


    private String name;

    public PartyMoveset4Parser() {
        super(0);
    }

    protected PartyMoveset4Parser(final int slot) {
        super(slot);

    }
    @Override
    public String getID() {
        return "party_" + this.slot + "_four_" + "moveset";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {

            CobblemonExpansion.registerParser(new PartyMoveset4Parser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon pokemon, String[] p2) {
        return pokemon.getMoveSet().getMoves().size() >= 4 ? pokemon.getMoveSet().get(3).getDisplayName().getString() : "Empty";
    }

}

