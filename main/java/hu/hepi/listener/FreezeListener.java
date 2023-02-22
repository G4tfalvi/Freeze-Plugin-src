package hu.hepi.listener;

import hu.hepi.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener {

    @EventHandler
    public static void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(Main.fagyasztva.contains(p)){
            e.setCancelled(true);

            return;
        }
    }
}
