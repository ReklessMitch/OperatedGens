package me.reklessmitch.mitchgenerators.cmds;

import me.reklessmitch.mitchgenerators.guis.GeneratorGUI;
import org.bukkit.entity.Player;

public class CmdGenGUI extends GeneratorCommands{

    public CmdGenGUI() {
        this.addAliases("gui");
    }

    @Override
    public void perform() {
        Player player = (Player) sender;
        new GeneratorGUI(player).open();
    }
}
