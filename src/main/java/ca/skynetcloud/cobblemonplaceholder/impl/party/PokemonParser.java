
package ca.skynetcloud.cobblemonplaceholder.impl.PokemonParser;

import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PokemonGet implements Parser {

    @Override
    public String getID() {
        return "party_" + this.slot + "_pokemon";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new PokemonParser(i));
        }
    }

    @Override
    public static Pokemon parse(final Player player, final String[] args) throws NoPokemonStoreException {
        int slot = Integer.parseInt(args[0]);
        return getPokemon(player, slot);
    }
}
