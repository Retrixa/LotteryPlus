package retrixastudios.lotteryplus.manager;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import retrixastudios.lotteryplus.LotteryPlus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

public class LotteryManager {

    private LotteryPlus plugin;
    private ArrayList<UUID> entries;

    private long lotteryTime;

    public LotteryManager(LotteryPlus plugin) {
        this.entries = new ArrayList<>();
        this.plugin = plugin;
        this.lotteryTime = plugin.getConfig().getLong("lottery.runtime");
    }

    public void addEntry(UUID player, int amount) {

        for(int i = 0; i < amount; i++) {
            entries.add(player);
        }
        Collections.shuffle(entries); // Shuffle the entries for randomness.
    }

    public UUID getRandomWinner() {
        Random random = new Random();
        ArrayList<UUID> copied = entries; // Create a copy to select from.
        entries.clear(); // Reset the lottery.
        return copied.get(random.nextInt(copied.size())); // Return a random player UUID.
    }

    public int getEntries() {
        return entries.size();
    }

    public int getUniques() {
        ArrayList<UUID> uniques = new ArrayList<>();
        for(UUID u : entries) {
            if(!uniques.contains(u)) uniques.add(u);
        }
        return uniques.size();
    }

}
