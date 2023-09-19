package me.reklessmitch.mitchgenerators.configs;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import lombok.Getter;
import me.reklessmitch.mitchgenerators.object.Generator;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;

import java.util.EnumMap;
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
                GeneratorTier.COMMON, new Generator(GeneratorTier.COMMON, 120, 100),
                GeneratorTier.UNCOMMON, new Generator(GeneratorTier.UNCOMMON,  100, 200),
                GeneratorTier.RARE, new Generator(GeneratorTier.RARE,  80, 300),
                GeneratorTier.EPIC, new Generator(GeneratorTier.EPIC,  60, 400),
                GeneratorTier.LEGENDARY, new Generator(GeneratorTier.LEGENDARY, 40, 500)
        );
        gens.put(GeneratorType.MONEY, gen);
        gens.put(GeneratorType.ORB, gen);
        gens.put(GeneratorType.SPAWNER, gen);
        return gens;

    }
}
