package me.reklessmitch.mitchgenerators.guis;

import com.massivecraft.massivecore.chestgui.ChestGui;
import com.massivecraft.massivecore.util.ItemBuilder;
import me.reklessmitch.mitchgenerators.configs.GeneratorPlayer;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import java.util.List;
import java.util.Map;

public class GeneratorGUI extends ChestGui {

    private final Player player;
    private final GeneratorPlayer generatorPlayer;

    public GeneratorGUI(Player player) {
        this.player = player;
        this.generatorPlayer = GeneratorPlayer.get(player);
        setInventory(Bukkit.createInventory(null, 9, "Generator"));
        init();
        add();
    }

    public void init() {
        Map<GeneratorTier, Integer> moneyGens = generatorPlayer.getGenerators().get(GeneratorType.MONEY);
        Map<GeneratorTier, Integer> orbGens = generatorPlayer.getGenerators().get(GeneratorType.ORB);
        Map<GeneratorTier, Integer> spawnerGens = generatorPlayer.getGenerators().get(GeneratorType.SPAWNER);

        actions(GeneratorType.MONEY, 1, moneyGens, Material.GOLD_INGOT, "§6Money Generator");
        actions(GeneratorType.ORB, 4, orbGens, Material.EXPERIENCE_BOTTLE, "§bOrb Generator");
        actions(GeneratorType.SPAWNER, 7, spawnerGens, Material.CREEPER_SPAWN_EGG, "§aSpawner Generator");
    }
    private void actions(GeneratorType type, int slot, Map<GeneratorTier, Integer> gens, Material material, String name){

        getInventory().setItem(slot, new ItemBuilder(material).displayname(name).lore(getLore(type, gens))
                .flag(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS).build());
        setAction(slot, event -> {
            event.getWhoClicked().sendMessage(generatorPlayer.getAmountMade().get(type) + " " + type.toString() + " made!");
            return true;
        });

    }

    private List<String> getLore(GeneratorType type, Map<GeneratorTier, Integer> gens){
        long amountMade = generatorPlayer.getAmountMade().get(type);
        return List.of("§aAmounts: ", "§f" +
                gens.get(GeneratorTier.COMMON) + " Common", "§f" +
                gens.get(GeneratorTier.UNCOMMON) + " Uncommon", "§f" +
                gens.get(GeneratorTier.RARE) + " Rare", "§f" +
                gens.get(GeneratorTier.EPIC) + " Epic", "§f" +
                gens.get(GeneratorTier.LEGENDARY) + " Legendary",
                "",
                "§aAmount Made: " + amountMade);
    }

    public void open() {
        player.openInventory(getInventory());
    }
}
