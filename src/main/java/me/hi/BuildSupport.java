package me.hi;

import org.bukkit.plugin.java.JavaPlugin;

public final class BuildSupport extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register command executors
        getCommand("rain").setExecutor(new RainToggleCommand());
        getCommand("mobspawn").setExecutor(new MobSpawnToggleCommand());
        
        // Register leaf decay command and its event listener
        LeafDecayToggleCommand leafDecayCommand = new LeafDecayToggleCommand(this);
        getCommand("leafdecay").setExecutor(leafDecayCommand);
        getServer().getPluginManager().registerEvents(leafDecayCommand, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
