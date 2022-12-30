package codes.jesse.serveronline;

import org.bukkit.plugin.java.JavaPlugin;

public final class ServerOnline extends JavaPlugin {
    private static ServerOnline plugin;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerPresenceListener(), this);

        new DiscordMessage("Minecraft server started! :zap: :hammer_pick:\n" + buildHostnameGreeting()).send();
    }

    @Override
    public void onDisable() {
        new DiscordMessage("Minecraft server shut down. :sleeping: :zzz:").send();
    }

    private String getHostname() {
        try {
            return getConfigString("hostname");
        } catch (Exception e) {
            getLogger().warning(e.getMessage());
            return "";
        }
    }

    private String buildHostnameGreeting() {
        String hostname = getHostname();

        if (hostname.equals("")) {
            return "Hop on in!";
        } else {
            return "Hop on in at: `" + hostname + "`";
        }
    }

    public String getConfigString(String path) {
        String value = this.getConfig().getString(path);

        if (value == null || value.equals("")) {
            return "";
        } else {
            return value;
        }
    }

    public static ServerOnline getPlugin() {
        return plugin;
    }
}