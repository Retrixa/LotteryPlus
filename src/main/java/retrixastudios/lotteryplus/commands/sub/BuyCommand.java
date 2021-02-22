package retrixastudios.lotteryplus.commands.sub;

import org.bukkit.entity.Player;
import retrixastudios.lotteryplus.commands.SubCommand;

public class BuyCommand extends SubCommand {

    @Override
    public String getName() {
        return "buy";
    }

    @Override
    public String getDescription() {
        return "Command to buy lottery tickets!";
    }

    @Override
    public String getSyntax() {
        return "/lottery buy (amount)";
    }

    @Override
    public String getPermission() {
        return "lottery.use";
    }

    @Override
    public void execute(Player player, String... args) {
        // Buy a ticket.
    }
}
