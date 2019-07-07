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
        message = message.replaceAll("\\*\\*(.+?)\\*\\*", "&l$1&r");
        message = message.replaceAll("\\*(.+?)\\*", "&o$1&r");
        message = message.replaceAll("__(.+?)__", "&n$1&r");
        message = message.replaceAll("_(.+?)_", "&o$1&r");
        message = message.replaceAll("~~(.+?)~~", "&m$1&r");
        message = message.replaceAll("`(.+?)`", "&k$1&r");
        event.setMessage(message);
    }
}
