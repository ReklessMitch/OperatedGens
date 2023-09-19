package me.reklessmitch.mitchgenerators.object;

import lombok.Getter;

@Getter
public class Generator {

    private GeneratorTier type;
    private int spawnRateInSeconds;
    private int spawnAmount;

    public Generator(GeneratorTier type, int spawnRateInSeconds, int spawnAmount) {
        this.type = type;
        this.spawnRateInSeconds = spawnRateInSeconds;
        this.spawnAmount = spawnAmount;
    }


}
