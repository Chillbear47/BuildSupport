package me.hi;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RainToggleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        World world = player.getWorld();
        
        // Toggle weather - if it's currently raining, stop it; otherwise start it
        boolean isRaining = world.hasStorm();
        world.setStorm(!isRaining);
        world.setThundering(false); // Also disable thunder when toggling
        
        if (!isRaining) {
            player.sendMessage(ChatColor.GREEN + "Rain has been enabled in " + world.getName());
        } else {
            player.sendMessage(ChatColor.GREEN + "Rain has been disabled in " + world.getName());
        }
        
        return true;
    }
}
