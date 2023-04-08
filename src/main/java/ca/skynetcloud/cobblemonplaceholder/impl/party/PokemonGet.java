
package ca.skynetcloud.cobblemonplaceholder.impl.PokemonGet;

import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PokemonGet implements Parser {

    @Override
    public Pokemon parse(final Player player, final String[] args) throws NoPokemonStoreException {
        int slot = Integer.parseInt(args[0]);
        return getPokemon(player, slot);
    }

    @Override
    public void register() {
        // Do nothing (empty implementation)
    }

    @Override
    public String getID() {
        return null; // or return some default value
    }
}