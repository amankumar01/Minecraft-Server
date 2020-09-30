package me.amankumar.ranksmanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.amankumar.ranksmanager.players.Players;
import me.amankumar.ranksmanager.staff.Admin;
import me.amankumar.ranksmanager.staff.Helper;
import me.amankumar.ranksmanager.staff.Manager;
import me.amankumar.ranksmanager.staff.Mod;
import me.amankumar.ranksmanager.staff.Owner;

public class RankSet implements CommandExecutor {
	
	RanksManager instance;
	
	public RankSet(RanksManager instance) {
		this.instance = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("rankset")) {
			if(!(sender instanceof Player)) 
				return true;
			Player player = (Player) sender;
			if(!player.hasPermission("rankset.use")) {
				player.sendMessage(ChatColor.RED + "You Do Not have permission to use this command");
				return true;
			}
			// use is going to be /rankset <name> <rank>
			if(args.length < 2) {
				player.sendMessage(ChatColor.RED + "Usage: /rankset <name> <rank>");
				return true;
			}
			String rank = args[1];
			String playerName = args[0];
			Player rankPlayer = null;
			for(Player pl : Bukkit.getOnlinePlayers()) {
				if(pl.getName().equalsIgnoreCase(playerName))
					rankPlayer = pl;
			}
			if(rankPlayer == null) return true;
			boolean bool = whichRank(rankPlayer, rank);
			player.sendMessage(ChatColor.GREEN + "You have made " + playerName + " an " + (bool ? rank : "player"));
			return true;
		}
		return false;
	}
	
	public boolean whichRank(Player player, String rank) {
		if(rank.equalsIgnoreCase("Owner")) {
			Owner owner = new Owner(instance);
			owner.addToFile(player);
			return true;
		}
		
		if(rank.equalsIgnoreCase("Manager")) {
			Manager manager = new Manager(instance);
			manager.addToFile(player);
			return true;
		}
		
		if(rank.equalsIgnoreCase("Admin")) {
			Admin admin = new Admin(instance);
			admin.addToFile(player);
			return true;
		}
		
		if(rank.equalsIgnoreCase("Mod")) {
			Mod mod = new Mod(instance);
			mod.addToFile(player);
			return true;
		}
		
		if(rank.equalsIgnoreCase("Helper")) {
			Helper helper = new Helper(instance);
			helper.addToFile(player);
			return true;
		}
		
		Players pl = new Players(instance);
		pl.addToFile(player);
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
