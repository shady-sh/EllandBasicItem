package com.elland.rpgsystems.ellandbasicitem.eventhandler;

import com.elland.rpgsystems.ellandbasicitem.EllandBasicItemAPI;
import com.elland.rpgsystems.ellandbasicitem.Main;
import com.elland.rpgsystems.ellandbasicitem.databases.BasicItemPlayerDB;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class EtcEvents implements Listener {
    Main main = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        List<ItemStack> itemStackList = EllandBasicItemAPI.getBasicItemList();
        Bukkit.getScheduler().runTaskLater(main, () -> {
            Document info = BasicItemPlayerDB.findOne(uuid);
            if (info == null) {
                Bukkit.getScheduler().runTaskLater(main, () -> {
                    p.sendTitle(main.getMsg("S00001"),
                            main.getMsg("S00002"), 5, 55, 5);
                    main.sendMsg(p, "S00003");
                    itemStackList.forEach((itemStack) -> p.getInventory().addItem(itemStack));
                }, 60L);
            }
            BasicItemPlayerDB.create(p);
        }, 1L);
    }
}
