package me.reklessmitch.mitchgenerators.configs;

import com.massivecraft.massivecore.store.Coll;


public class GeneratorConfColl extends Coll<GeneratorConf> {

    private static final GeneratorConfColl i = new GeneratorConfColl();
    public static GeneratorConfColl get() { return i; }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        if(!active){
            return;
        }
        GeneratorConf.i = this.get("conf", true);
    }
}