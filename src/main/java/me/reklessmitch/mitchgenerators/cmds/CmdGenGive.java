package me.reklessmitch.mitchgenerators.cmds;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;
import com.massivecraft.massivecore.command.type.sender.TypePlayer;
import me.reklessmitch.mitchgenerators.Perm;
import me.reklessmitch.mitchgenerators.configs.GeneratorPlayer;
import me.reklessmitch.mitchgenerators.object.GeneratorTier;
import me.reklessmitch.mitchgenerators.object.GeneratorType;
import me.reklessmitch.mitchgenerators.utils.TypeGeneratorTier;
import me.reklessmitch.mitchgenerators.utils.TypeGeneratorType;
import org.bukkit.entity.Player;

import java.util.Map;

public class CmdGenGive extends GeneratorCommands{

    public CmdGenGive() {
        this.addAliases("give");
        this.addParameter(TypePlayer.get(), "player");
        this.addParameter(TypeGeneratorType.get(), "type");
        this.addParameter(TypeGeneratorTier.get(), "tier");
        this.addParameter(TypeInteger.get(), "amount");
        this.addRequirements(RequirementHasPerm.get(Perm.ADMIN));
    }

    @Override
    public void perform() throws MassiveException {
        Player player = this.readArg();
        GeneratorType type = this.readArg();
        GeneratorTier tier = this.readArg();
        int amount = this.readArg();

        GeneratorPlayer generatorPlayer = GeneratorPlayer.get(player);
        Map<GeneratorTier, Integer> genAmounts = generatorPlayer.getGenerators().get(type);
        genAmounts.replace(tier, genAmounts.get(tier) + amount);
    }

}
