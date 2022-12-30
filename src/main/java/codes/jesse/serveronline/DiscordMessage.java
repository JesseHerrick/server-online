package codes.jesse.serveronline;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DiscordMessage {
    public String hostname;
    private JSONObject body = new JSONObject();

    public DiscordMessage(String message) {
        body.put("content", message);
    }

    public void send() {
        String discordWebhookUrl = ServerOnline.getPlugin().getConfigString("discord_webhook_url");

        if (!discordWebhookUrl.equals("")) {
            URI discordWebhookUri = URI.create(discordWebhookUrl);

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
                ServerOnline.getPlugin().getLogger().warning("An error occurred sending the message: " + e.getMessage());
            }
        }
    }
}
