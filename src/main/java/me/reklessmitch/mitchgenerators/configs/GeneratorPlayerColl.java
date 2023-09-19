package me.reklessmitch.mitchgenerators.configs;

import com.massivecraft.massivecore.store.SenderColl;

public class GeneratorPlayerColl extends SenderColl<GeneratorPlayer> {

    private static final GeneratorPlayerColl i = new GeneratorPlayerColl();
    public static GeneratorPlayerColl get() {
        return i;
    }

}