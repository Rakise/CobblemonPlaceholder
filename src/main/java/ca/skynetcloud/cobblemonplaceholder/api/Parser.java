package ca.skynetcloud.cobblemonplaceholder.api;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface  Parser {

    String getID();

    void register();

    Object parse(final Player p0, final String[]p1) throws NoPokemonStoreException;

    default Pokemon getPokemon(final Player player, int slot) throws NoPokemonStoreException {
            return Cobblemon.INSTANCE.getStorage().getParty(player.getUniqueId()).get(slot - 1);

    }
}
public class CobblemonGetPokemon implements Parser {
    @Override
    public String getPoke(final Player player, int slot) throws NoPokemonStoreException {
        return Cobblemon.INSTANCE.getStorage().getParty(player.getUniqueId()).get(slot - 1);
    }

}
