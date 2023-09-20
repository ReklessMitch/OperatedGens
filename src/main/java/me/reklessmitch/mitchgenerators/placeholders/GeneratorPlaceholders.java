package me.reklessmitch.mitchgenerators.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.reklessmitch.mitchgenerators.configs.GeneratorPlayer;
import me.reklessmitch.mitchgenerators.object.GeneratorType;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class GeneratorPlaceholders extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "mitchgens";
    }

    @Override
    public @NotNull String getAuthor() {
        return "ReklessMitch";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        GeneratorPlayer generatorPlayer = GeneratorPlayer.get(player.getUniqueId());
        if(params.equalsIgnoreCase("money")){
            return generatorPlayer.getAmountMade().get(GeneratorType.MONEY).toString();
        }else if(params.equalsIgnoreCase("spawner")){
            return generatorPlayer.getAmountMade().get(GeneratorType.SPAWNER).toString();
        }else if(params.equalsIgnoreCase("orb")){
            return generatorPlayer.getAmountMade().get(GeneratorType.ORB).toString();
        }else {
            return "Invalid Currency";
        }
    }
}