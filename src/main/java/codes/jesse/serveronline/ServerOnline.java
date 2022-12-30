package codes.jesse.serveronline;

import org.bukkit.plugin.java.JavaPlugin;

public final class ServerOnline extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        sendMessage("Minecraft server started! :zap: :hammer_pick:\n" + buildHostnameGreeting());
    }

    @Override
    public void onDisable() {
        sendMessage("Minecraft server shut down. :sleeping: :zzz:");
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

    private void sendMessage(String message) {
        try {
            DiscordMessage dm = new DiscordMessage(this, message);
            dm.send();
        } catch (Exception e) {
            getLogger().warning(e.getMessage());
        }
    }


    public String getConfigString(String path) throws Exception {
        String value = this.getConfig().getString(path);

        if (value == null || value.equals("")) {
            throw new Exception("'" + path + "'" + " is blank in your config.yml file. Please add a value.");
        } else {
            return value;
        }
    }
}