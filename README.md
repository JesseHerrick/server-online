# server-online

Small Paper MC plugin to notify a Discord server channel when the server starts and stops.

## Installation

1. Add the plugin `jar` file to the `plugins/` folder of your Paper/Spigot MC server directory.
2. Start your Minecraft server once. On this first run, the plugin will simply copy default configuration into `plugins/ServerOnline/plugin.yml`.
3. Stop the server.
4. Open up `plugins/ServerOnline/plugin.yml` in your editor of choice.
5. Set `discord_webhook_url` to the [webhook generated by Discord](https://support.discord.com/hc/en-us/articles/228383668-Intro-to-Webhooks) to send messages into your chosen channel.
6. (Optional) Set `hostname` to your server's hostname or IP address.
7. Start the server again. You should see a startup message when you start the server and a shutdown message when you stop it.
