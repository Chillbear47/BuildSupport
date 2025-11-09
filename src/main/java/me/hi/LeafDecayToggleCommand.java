package me.hi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LeafDecayToggleCommand implements CommandExecutor, Listener {
    
    private boolean leafDecayDisabled = false;
    private final JavaPlugin plugin;
    
    public LeafDecayToggleCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Toggle leaf decay state
        leafDecayDisabled = !leafDecayDisabled;
        
        if (leafDecayDisabled) {
            sender.sendMessage(ChatColor.GREEN + "Leaf decay has been disabled");
        } else {
            sender.sendMessage(ChatColor.GREEN + "Leaf decay has been enabled");
        }
        
        return true;
    }
    
    @EventHandler
    public void onLeafDecay(LeavesDecayEvent event) {
        if (leafDecayDisabled) {
            event.setCancelled(true);
        }
    }
}
