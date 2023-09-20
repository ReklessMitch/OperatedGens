package me.reklessmitch.mitchgenerators;

import com.massivecraft.massivecore.MassivePlugin;
import lombok.Getter;
import me.reklessmitch.mitchgenerators.cmds.CmdGen;
import me.reklessmitch.mitchgenerators.configs.GeneratorConf;
import me.reklessmitch.mitchgenerators.configs.GeneratorConfColl;
import me.reklessmitch.mitchgenerators.configs.GeneratorPlayerColl;
import me.reklessmitch.mitchgenerators.object.Generator;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;
import me.reklessmitch.mitchgenerators.placeholders.GeneratorPlaceholders;
import org.bukkit.Bukkit;
import java.util.Map;


@Getter
public final class MitchGenerators extends MassivePlugin {

    private static MitchGenerators i;
    public static MitchGenerators get() { return i; }

    public MitchGenerators() {
        i = this;
        this.versionSynchronized = false;
    }

    @Override
    public void onEnableInner() {
        i = this;
        this.activate(
                // --- Collections ---
                GeneratorPlayerColl.class, GeneratorConfColl.class,
                // --- Commands ---
                CmdGen.class



        );

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new GeneratorPlaceholders().register();
        }
        activate();
    }

    private void activate(){

        Map<GeneratorType, Map<GeneratorTier, Generator>> generators = GeneratorConf.get().getGenerators();
        for (Map.Entry<GeneratorType, Map<GeneratorTier, Generator>> typeEntry : generators.entrySet()) {
            GeneratorType generatorType = typeEntry.getKey();
            Map<GeneratorTier, Generator> tierMap = typeEntry.getValue();

            for (Map.Entry<GeneratorTier, Generator> tierEntry : tierMap.entrySet()) {
                GeneratorTier generatorTier = tierEntry.getKey();
                Generator generator = tierEntry.getValue();

                Bukkit.getScheduler().runTaskTimerAsynchronously(this, () ->
                GeneratorPlayerColl.get().getAll().forEach(generatorPlayer -> {
                    int amountOfGens = generatorPlayer.getGenerators().get(generatorType).get(generatorTier);
                    long amountToAdd = (long) generator.getSpawnAmount() * amountOfGens;
                    long amountMade = generatorPlayer.getAmountMade().get(generatorType).get(generatorTier);
                    generatorPlayer.getAmountMade().get(generatorType).replace(generatorTier, amountMade + amountToAdd);
                    generatorPlayer.changed();
                }), 0, generator.getSpawnRateInSeconds() * 20L);
            }
        }
    }

    @Override
    public void onDisable() {
        i = null;
        super.onDisable();
    }
}
