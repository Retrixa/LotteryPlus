package retrixastudios.lotteryplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import retrixastudios.lotteryplus.util.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor, TabCompleter {

    private ArrayList<SubCommand> commands;

    public CommandManager() {
        this.commands = new ArrayList<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length > 0) {
                for(SubCommand cmd : commands) {
                    if(args[0].equalsIgnoreCase(cmd.getName())) {
                        if(player.hasPermission(cmd.getPermission())) {
                            cmd.execute(player, args);
                        } else {
                            ChatUtils.tell(player, "You don't have permission to do this!");
                        }
                        return true;
                    }
                }
            }
            ChatUtils.tell(player, "Unknown Command.");
        }

        return true;
    }



    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> tabComplete = new ArrayList<>();

        switch (args.length) {
            case 1: { // SubCommand
                for(SubCommand cmd : commands) {
                    if(cmd.getName().toLowerCase().startsWith(args[0].toLowerCase())) tabComplete.add(cmd.getName());
                }
                return tabComplete;
            }
            case 2: { // Parameters
                if(args[0].equalsIgnoreCase("buy")) {
                    for(int i = 1; i < 5; i++) {
                        tabComplete.add(""+i);
                    }
                }
                return tabComplete;
            }
            default: return tabComplete;
        }
    }
}
