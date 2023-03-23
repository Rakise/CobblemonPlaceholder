

package ca.skynetcloud.cobblemonplaceholder.impl.party;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.util.LocalizationUtilsKt;
import net.minecraft.network.chat.Component;
import org.bukkit.entity.Player;

public class NatureParser extends PartyParser
{
    private final boolean isMint;
    
    public NatureParser() {
        super(0);
        this.isMint = false;
    }
    
    protected NatureParser(final int slot, final boolean isMint) {
        super(slot);
        this.isMint = isMint;
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_" + (this.isMint ? "mint" : "nature");
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new NatureParser(i, true));
            CobblemonExpansion.registerParser(new NatureParser(i, false));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return Text.capitalizeWord(pokemon.getNature().getName().getPath().replace("_", " "));
    }
}
