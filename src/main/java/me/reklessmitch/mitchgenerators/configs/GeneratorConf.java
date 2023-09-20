package me.reklessmitch.mitchgenerators.configs;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import lombok.Getter;
import me.reklessmitch.mitchgenerators.object.Generator;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
@EditorName("config")
public class GeneratorConf extends Entity<GeneratorConf> {

    public static GeneratorConf i = new GeneratorConf();
    public static GeneratorConf get() { return i; }

    private Map<GeneratorType, Map<GeneratorTier, Generator>> generators = defaultGenerators();

    private Map<GeneratorType, Map<GeneratorTier, Generator>> defaultGenerators(){
        Map<GeneratorType, Map<GeneratorTier, Generator>> gens = new EnumMap<>(GeneratorType.class);
        Map<GeneratorTier, Generator> gen = Map.of(
                GeneratorTier.COMMON, new Generator(GeneratorTier.COMMON, 120, 100, List.of("give %player% stick %amount%")),
                GeneratorTier.UNCOMMON, new Generator(GeneratorTier.UNCOMMON,  100, 200, List.of("give %player% stick %amount%")),
                GeneratorTier.RARE, new Generator(GeneratorTier.RARE,  80, 300, List.of("give %player% stick %amount%")),
                GeneratorTier.EPIC, new Generator(GeneratorTier.EPIC,  60, 400, List.of("give %player% stick %amount%")),
                GeneratorTier.LEGENDARY, new Generator(GeneratorTier.LEGENDARY, 40, 500, List.of("give %player% stick %amount%"))
        );
        gens.put(GeneratorType.MONEY, gen);
        gens.put(GeneratorType.ORB, gen);
        gens.put(GeneratorType.SPAWNER, gen);
        return gens;

    }
}
