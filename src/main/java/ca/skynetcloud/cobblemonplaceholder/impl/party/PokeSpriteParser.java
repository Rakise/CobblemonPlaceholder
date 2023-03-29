
package ca.skynetcloud.cobblemonplaceholder.impl.party;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PokeSpriteParser extends PartyParser
{
    public PokeSpriteParser() {
        super(0);
    }

    protected PokeSpriteParser(final int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_sprite";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new PokeSpriteParser(i));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getSpecies().getName();
    }
}
