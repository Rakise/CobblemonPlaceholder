package ca.skynetcloud.cobblemonplaceholder.impl.party;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.abilities.PotentialAbility;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.abilities.HiddenAbility;
import org.bukkit.entity.Player;


public class HiddenAbilityParser extends PartyParser
{
    public HiddenAbilityParser() {
        super(0);
    }

    protected HiddenAbilityParser(final int slot) {
        super(slot);
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_hidden_ability";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new HiddenAbilityParser(i));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        for (PotentialAbility ability : pokemon.getForm().getAbilities()) {
            if (ability instanceof HiddenAbility) {
                if (ability.getTemplate().equals(pokemon.getAbility().getTemplate())) {
                    return "Yes";
                }
            }
        }
        return "No";
    }
}
