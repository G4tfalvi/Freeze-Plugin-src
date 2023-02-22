package hu.hepi;

import hu.hepi.listener.FreezeListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public static ArrayList<Player> fagyasztva = new ArrayList<>();

    public String cc(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);

        getServer().getConsoleSender().sendMessage(cc("&cFreeze plugin loaded!"));
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("freeze")){
            if(!sender.hasPermission("freeze.use")){
                sender.sendMessage(cc("&8(&c!&8) &cNo permission."));
                return true;
            }else {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    Player s = (Player) sender;

                    if (target == null) {
                        sender.sendMessage(cc("&8(&c!&8) &cPlayer is not online!"));
                        return true;
                    } else {
                        fagyasztva.add(target);
                        target.sendMessage(cc("&8(&c!&8) &cYou have been frozen By &f" + ((Player) sender).getDisplayName()));
                        sender.sendMessage(cc("&8(&c!&8) &cYou have frozen &f" + target.getDisplayName()));
                        return true;
                    }
                }else{
                    sender.sendMessage(cc("&8(&c!&8) &fUsage: &c/freeze <player>"));
                    return true;
                }


            }
        }

        if(label.equalsIgnoreCase("unfreeze")){
            if(!sender.hasPermission("freeze.use")){
                sender.sendMessage(cc("&8(&c!&8) &cNo permission."));
                return true;
            }else {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    Player s = (Player) sender;

                    if (target == null) {
                        sender.sendMessage(cc("&8(&c!&8) &cPlayer is not online!"));
                        return true;
                    } else {
                        fagyasztva.remove(target);
                        target.sendMessage(cc("&8(&c!&8) &cYou have been unfrozen by &f" + ((Player) sender).getDisplayName()));
                        sender.sendMessage(cc("&8(&c!&8) &cYou have unfrozen &f" + target.getDisplayName()));
                        return true;
                    }
                }else{
                    sender.sendMessage(cc("&8(&c!&8) &fUsage: &c/unfreeze <player>"));
                    return true;
                }


            }
        }

        return false;
    }
}
