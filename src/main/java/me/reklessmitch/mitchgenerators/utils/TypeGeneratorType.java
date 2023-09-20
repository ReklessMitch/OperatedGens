package me.reklessmitch.mitchgenerators.utils;

import com.massivecraft.massivecore.command.type.TypeAbstract;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TypeGeneratorType extends TypeAbstract<GeneratorType> {

    private static final TypeGeneratorType i = new TypeGeneratorType();
    public static TypeGeneratorType get() {
        return i;
    }

    public TypeGeneratorType() {
        super(GeneratorType.class);
    }

    @Override
    public GeneratorType read(String s, CommandSender commandSender) {
        return GeneratorType.valueOf(s);
    }

    public Collection<String> getTabList(CommandSender commandSender, String s) {
        GeneratorType[] tiers = GeneratorType.values();
        List<String> tierNames = new ArrayList<>();

        for (GeneratorType tier : tiers) {
            tierNames.add(tier.toString());
        }

        return tierNames;
    }
}