package me.reklessmitch.mitchgenerators.utils;

import com.massivecraft.massivecore.command.type.TypeAbstract;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TypeGeneratorTier extends TypeAbstract<GeneratorTier> {

    private static final TypeGeneratorTier i = new TypeGeneratorTier();
    public static TypeGeneratorTier get() {
        return i;
    }

    public TypeGeneratorTier() {
        super(GeneratorTier.class);
    }

    @Override
    public GeneratorTier read(String s, CommandSender commandSender) {
        return GeneratorTier.valueOf(s);
    }

    public Collection<String> getTabList(CommandSender commandSender, String s) {
        GeneratorTier[] tiers = GeneratorTier.values();
        List<String> tierNames = new ArrayList<>();

        for (GeneratorTier tier : tiers) {
            tierNames.add(tier.toString());
        }

        return tierNames;
    }
}
