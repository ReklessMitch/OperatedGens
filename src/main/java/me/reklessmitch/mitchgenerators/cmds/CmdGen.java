package me.reklessmitch.mitchgenerators.cmds;

public class CmdGen extends GeneratorCommands{

    private static CmdGen i = new CmdGen();
    public static CmdGen get() {return i;}

    private CmdGenGUI cmdGenGUI = new CmdGenGUI();

    public CmdGen() {
        this.addAliases("gen");
        this.addChild(this.cmdGenGUI);
    }
}
