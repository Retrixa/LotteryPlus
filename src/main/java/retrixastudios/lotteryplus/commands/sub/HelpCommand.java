package retrixastudios.lotteryplus.commands.sub;

import org.bukkit.entity.Player;
import retrixastudios.lotteryplus.commands.SubCommand;

import java.util.ArrayList;

public class HelpCommand extends SubCommand {

    private ArrayList<SubCommand> commands;

    public HelpCommand(ArrayList<SubCommand> commands) {
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Command to show this help menu!";
    }

    @Override
    public String getSyntax() {
        return "/lottery help";
    }

    @Override
    public String getPermission() {
        return "lottery.use";
    }

    @Override
    public void execute(Player player, String... args) {
        // Show the help menu.
    }
}
