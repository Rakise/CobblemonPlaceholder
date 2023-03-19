package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import ca.skynetcloud.cobblemonplaceholder.impl.global.CobblemonVersionParser;
import ca.skynetcloud.cobblemonplaceholder.impl.global.SpeciesTotalCountParser;
import ca.skynetcloud.cobblemonplaceholder.impl.party.*;
import ca.skynetcloud.cobblemonplaceholder.impl.party.evs.*;
import ca.skynetcloud.cobblemonplaceholder.impl.party.ivs.*;
import ca.skynetcloud.cobblemonplaceholder.impl.party.moveset.PartyMoveset1Parser;
import ca.skynetcloud.cobblemonplaceholder.impl.party.moveset.PartyMoveset2Parser;
import ca.skynetcloud.cobblemonplaceholder.impl.party.moveset.PartyMoveset3Parser;
import ca.skynetcloud.cobblemonplaceholder.impl.party.moveset.PartyMoveset4Parser;
import ca.skynetcloud.cobblemonplaceholder.impl.global.SpeciesImplTotalCountParser;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.google.common.collect.Sets;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Set;

public class CobblemonExpansion extends PlaceholderExpansion {

    private final Cobblemonplaceholder plugin;
    private static final Set<Parser> defaultParsers;
    private static final HashMap<String, Parser> parsers;

    public CobblemonExpansion(Cobblemonplaceholder plugin) {
        this.plugin = plugin;
    }

    public static void registerParser(final Parser parser) {
        CobblemonExpansion.parsers.put(parser.getID(), parser);
    }

    public boolean canRegister() {
        return true;
    }

    public @NotNull String getIdentifier() {
        return "cobblemon";
    }

    public @NotNull String getAuthor() {
        return "SkyNetCloud";
    }

    public @NotNull String getVersion() {
        return "0.0.6";
    }

    @Override
    public boolean persist() {
        return true; // This is required or else PlaceholderAPI will unregister the Expansion on reload
    }

    public boolean register() {
        CobblemonExpansion.defaultParsers.forEach(Parser::register);
        return super.register();
    }

    public String onRequest(final OfflinePlayer player, final @NotNull String identifier) {
        if (player != null && player.isOnline()) {
            return this.onPlaceholderRequest(player.getPlayer(), identifier);
        }
        return null;
    }

    public String onPlaceholderRequest(final Player p, final @NotNull String identifier) {
        if (p == null || !p.isOnline()) {
            return "INVALID_PLAYER";
        }
        final String formattedInput = identifier.replace("\\s+", "_").toLowerCase();
        final Player player = p.getPlayer();
        final Parser parser = CobblemonExpansion.parsers.get(formattedInput);
        if (parser != null) {
            final String[] args = formattedInput.split("_");
            try {
                return parser.parse(player, args).toString();
            } catch (NoPokemonStoreException e) {
                throw new RuntimeException(e);
            }
        }
        return "Could not parse request check syntax please";
    }

    static {
        defaultParsers = Sets.newHashSet(

                new BaseFriendshipParser(),
                new LowerCaseNicknameParser(),
                new EggGroupParser(),
                new HiddenAbilityParser(),
                new PartyMoveset4Parser(),
                new PartyMoveset3Parser(),
                new PartyMoveset2Parser(),
                new PartyMoveset1Parser(),

                new EvPercentageParser(),
                new IvPercentageParser(),

                new OTNameParser(),
                new OTUuidParser(),
                new NicknameParser(),
                new LegendaryParser(),
                new ShinyParser(),
                new UltraBeastsParser(),
                new CobblemonVersionParser(),
                new SpeciesImplTotalCountParser(),
                new SpeciesTotalCountParser(),

                new DexNumberParser(),
                new AbilityParser(),
                new ExperienceParser(),

                new PartyIvHpParser(),
                new PartyIvAttackParser(),
                new PartyIvDefenceParser(),
                new PartyIvSPAttackParser(),
                new PartyIvSPDefenceParser(),
                new PartyIvSpeedParser(),


                new PartyEvHpParser(),
                new PartyEvAttackParser(),
                new PartyEvDefenceParser(),
                new PartyEvSPAttackParser(),
                new PartyEvSPDefenceParser(),
                new PartyEvSpeedParser(),


                new GenderParser(),
                new NatureParser(),
                new PokeballParser(),
                new LevelParser()
        );
        parsers = new HashMap<>();
    }
}
