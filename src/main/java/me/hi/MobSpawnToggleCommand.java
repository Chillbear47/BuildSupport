package me.hi;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MobSpawnToggleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        World world = player.getWorld();
        
        // Toggle mob spawning
        boolean currentlyAllowed = world.getAllowMonsters();
        world.setSpawnFlags(!currentlyAllowed, world.getAllowAnimals());
        
        if (currentlyAllowed) {
            player.sendMessage(ChatColor.GREEN + "Mob spawning has been disabled in " + world.getName());
        } else {
            player.sendMessage(ChatColor.GREEN + "Mob spawning has been enabled in " + world.getName());
        }
        
        return true;
    }
}
