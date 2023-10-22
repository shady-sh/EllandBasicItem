package com.elland.rpgsystems.ellandbasicitem.eventhandler;

import com.elland.rpgsystems.ellandbasicitem.Main;
import com.elland.rpgsystems.ellandbasicitem.databases.BasicItemDB;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InvEvents implements Listener {
    Main main = Main.getPlugin(Main.class);

    @EventHandler
    public void onGuiClose(InventoryCloseEvent e) {
        String inventoryName = e.getView().getTitle();
        Player p = (Player) e.getPlayer();
        // [메뉴] [ 기초 아이템 설정 메뉴 ]
        if (inventoryName.equals(main.getMsg("S00004"))) {
            List<ItemStack> itemStackList = new ArrayList<>();
            for (ItemStack item : e.getInventory().getContents())
                if (item != null && item.getType() != Material.AIR) itemStackList.add(item);
            BasicItemDB.setList(itemStackList);
            main.sendMsg(p, "S00017");
        }
    }
}
