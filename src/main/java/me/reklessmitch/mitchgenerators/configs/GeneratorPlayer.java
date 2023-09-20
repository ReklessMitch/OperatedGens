package me.reklessmitch.mitchgenerators.configs;

import com.massivecraft.massivecore.store.SenderEntity;
import lombok.Getter;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

@Getter
public class GeneratorPlayer extends SenderEntity<GeneratorPlayer> {

    // -------------------------------------------- //
    //
    // -------------------------------------------- //
    // Gen Type, Gen Tier, Amount of Gens
    private Map<GeneratorType, Map<GeneratorTier, Integer>> generators = defaultGenerators();
    // Gen Type, Gen Tier, Amount Made
    private Map<GeneratorType, Map<GeneratorTier, Long>> amountMade = defaultAmountMade();


    private Map<GeneratorType, Map<GeneratorTier, Long>> defaultAmountMade() {
        Map<GeneratorType, Map<GeneratorTier, Long>> made = new EnumMap<>(GeneratorType.class);
        for (GeneratorType value : GeneratorType.values()) {
            Map<GeneratorTier, Long> gen = new EnumMap<>(GeneratorTier.class);
            for (GeneratorTier tier : GeneratorTier.values()) {
                gen.put(tier, 0L);
            }
            made.put(value, gen);
        }
        return made;
    }

    private Map<GeneratorType, Map<GeneratorTier, Integer>> defaultGenerators(){
        Map<GeneratorType, Map<GeneratorTier, Integer>> gens = new EnumMap<>(GeneratorType.class);
        Map<GeneratorTier, Integer> gen = Map.of(GeneratorTier.COMMON, 0, GeneratorTier.UNCOMMON, 0,
                GeneratorTier.RARE, 0, GeneratorTier.EPIC, 0, GeneratorTier.LEGENDARY, 0);
        gens.put(GeneratorType.MONEY, gen);
        gens.put(GeneratorType.ORB, gen);
        gens.put(GeneratorType.SPAWNER, gen);
        return gens;
    }

    public static GeneratorPlayer get(Object oid) {
        return GeneratorPlayerColl.get().get(oid);
    }

    @Override
    public GeneratorPlayer load(@NotNull GeneratorPlayer that) {
        super.load(that);
        return this;
    }
}