package codes.jesse.serveronline;

import org.bukkit.plugin.java.JavaPlugin;

public final class ServerOnline extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hello, world!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
