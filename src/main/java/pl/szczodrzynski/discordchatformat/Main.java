package pl.szczodrzynski.discordchatformat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChatLowest(final AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        message = message.replaceAll("&", "\u00A7");
        message = message.replaceAll("\\*\\*(.+?)\\*\\*", "\u00A7l$1\u00A7r");
        message = message.replaceAll("\\*(.+?)\\*", "\u00A7o$1\u00A7r");
        message = message.replaceAll("__(.+?)__", "\u00A7n$1\u00A7r");
        message = message.replaceAll("_(.+?)_", "\u00A7o$1\u00A7r");
        message = message.replaceAll("~~(.+?)~~", "\u00A7m$1\u00A7r");
        message = message.replaceAll("`(.+?)`", "\u00A7k$1\u00A7r");
        event.setMessage(message);
    }
}
