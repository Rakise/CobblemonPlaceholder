
package ca.skynetcloud.cobblemonplaceholder.impl.PokemonGet;

import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import com.cobblemon.mod.common.Cobblemon;
import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import ca.skynetcloud.cobblemonplaceholder.util.text.Text;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PokemonGet {

    public static Pokemon parse(final Player player, final String[] args) throws NoPokemonStoreException {
        int slot = Integer.parseInt(args[0]);
        return pickPokemon(player, slot);
    }

    public static Pokemon pickPokemon(final Player player, int slot) throws NoPokemonStoreException {
        return Cobblemon.INSTANCE.getStorage().getParty(player.getUniqueId()).get(slot - 1);
    }
}