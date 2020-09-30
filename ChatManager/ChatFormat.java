package me.amankumar.chatformat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.amankumar.ranksmanager.RanksManager;
import net.md_5.bungee.api.ChatColor;

public class ChatFormat extends JavaPlugin implements Listener {
	
	RanksManager rm;

	public void onEnable() { 
		this.getServer().getPluginManager().registerEvents(this, this);
		rm = JavaPlugin.getPlugin(RanksManager.class);
	}
	
	public void onDisable() { 
		
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		String playerMessage = event.getMessage();
		String rank = rm.getRank(player);
		
		String groupFormat = "";
		if(rank == "player") {
			groupFormat = rm.getRFM().getConfig().getString("ranks.format." + rank);
		} else {
			groupFormat = rm.getRFM().getConfig().getString("ranks.staff.format." + rank);
		}
		
		String format = "<group-prefix><player-name><group-suffix> <message>";
		
		format = format.replace("<group-prefix>", groupFormat);
		format = format.replace("<player-name>", ChatColor.RESET + "%s");
		format = format.replace("<group-suffix>", ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + 
				"CustomTag" + ChatColor.DARK_GRAY + "]");
		format = format.replace("<message>", ChatColor.RESET + "%s");
		event.setFormat(format);
		event.setMessage(playerMessage);
		
	}
}
