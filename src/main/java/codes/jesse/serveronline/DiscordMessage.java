package codes.jesse.serveronline;

import org.json.simple.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class DiscordMessage {
    public URI discordWebhookUri;
    public String hostname;
    JSONObject body = new JSONObject();

    private ServerOnline plugin;

    public DiscordMessage(ServerOnline plugin, String message) throws Exception {
        this.plugin = plugin;
        this.discordWebhookUri = URI.create(plugin.getConfigString("discord_webhook_url"));

        this.body.put("content", message);
    }

    public void send() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(discordWebhookUri)
                .header("Content-Type", "application/json")
                .version(HttpClient.Version.HTTP_1_1)
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch(Exception e) {
            plugin.getLogger().warning("An error occurred sending the message: " + e.getMessage());
        }
    }
}
