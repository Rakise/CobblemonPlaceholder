package ca.skynetcloud.cobblemonplaceholder.impl.party;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.util.LocalizationUtilsKt;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.bukkit.entity.Player;


public class AbilityParser extends PartyParser
{
    public AbilityParser() {
        super(0);
    }
    
    protected AbilityParser(final int slot) {
        super(slot);
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_ability";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new AbilityParser(i));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return LocalizationUtilsKt.lang(pokemon.getAbility().getName()).getString().replace("cobblemon.", "");
    }
}
