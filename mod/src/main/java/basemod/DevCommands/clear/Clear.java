package basemod.DevCommands.clear;

import basemod.DevCommands.ConsoleCommand;
import basemod.DevConsole;
import basemod.helpers.ConvertHelper;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class Clear extends ConsoleCommand {

    public Clear() {
        maxExtraTokens = 1;
        simpleCheck = true;
    }

    @Override
    public void execute(String[] tokens, int depth) {
        if (tokens.length < 2) {
            clearLog();
            clearCmds();
        } else if (tokens[1].equals("log")) {
            clearLog();
        } else if (tokens[1].equals("cmd")) {
            clearCmds();
        } else {
            cmdClearHelp();
        }
    }

    public ArrayList<String> extraOptions(String[] tokens, int depth) {
        ArrayList<String> result = new ArrayList<>();

        result.add("log");
        result.add("cmd");

        return result;
    }

    @Override
    public void errorMsg() {
        cmdClearHelp();
    }

    // clear log
    private static void clearLog() {
        while (DevConsole.log.size() > 0) {
            DevConsole.log.remove(0);
        }
        while (DevConsole.prompted.size() > 0) {
            DevConsole.prompted.remove(0);
        }
    }

    // clear command list
    private static void clearCmds() {
        while (DevConsole.priorCommands.size() > 0) {
            DevConsole.priorCommands.remove(0);
        }
    }

    private static void cmdClearHelp() {
        DevConsole.couldNotParse();
        DevConsole.log("options are:");
        DevConsole.log("* log");
        DevConsole.log("* cmd");
    }
}