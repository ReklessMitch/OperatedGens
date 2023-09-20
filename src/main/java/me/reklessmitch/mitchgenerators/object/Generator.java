package me.reklessmitch.mitchgenerators.object;

import lombok.Getter;

import java.util.List;

@Getter
public class Generator {

    private GeneratorTier type;
    private int spawnRateInSeconds;
    private int spawnAmount;
    private List<String> commands;

    public Generator(GeneratorTier type, int spawnRateInSeconds, int spawnAmount, List<String> commands) {
        this.type = type;
        this.spawnRateInSeconds = spawnRateInSeconds;
        this.spawnAmount = spawnAmount;
        this.commands = commands;
    }


}
