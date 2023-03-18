package ca.skynetcloud.cobblemonplaceholder.impl.global;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import org.bukkit.entity.Player;

public class SpeciesImplTotalCountParser implements Parser
{
    @Override
    public String getID() {
        return "impl_species_total_count";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new SpeciesImplTotalCountParser());
        }
    }

    @Override
    public Object parse(Player p0, String[] p1) throws NoPokemonStoreException {
        return PokemonSpecies.INSTANCE.getImplemented().size();
    }

}
