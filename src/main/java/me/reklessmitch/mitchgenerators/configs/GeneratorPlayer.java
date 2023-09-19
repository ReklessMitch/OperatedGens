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
    private Map<GeneratorType, Long> amountMade = defaultAmountMade();

    private Map<GeneratorType, Long> defaultAmountMade() {
        Map<GeneratorType, Long> made = new EnumMap<>(GeneratorType.class);
        made.put(GeneratorType.MONEY, 0L);
        made.put(GeneratorType.ORB, 0L);
        made.put(GeneratorType.SPAWNER, 0L);
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