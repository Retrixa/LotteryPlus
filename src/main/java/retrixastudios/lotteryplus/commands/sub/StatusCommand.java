package retrixastudios.lotteryplus.commands.sub;

import org.bukkit.entity.Player;
import retrixastudios.lotteryplus.commands.SubCommand;

public class StatusCommand extends SubCommand {

    @Override
    public String getName() {
        return "status";
    }

    @Override
    public String getDescription() {
        return "Command to show the current status of the lottery!";
    }

    @Override
    public String getSyntax() {
        return "/lottery status";
    }

    @Override
    public String getPermission() {
        return "lottery.use";
    }

    @Override
    public void execute(Player player, String... args) {

    }
}
