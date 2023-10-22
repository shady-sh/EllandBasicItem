package com.elland.rpgsystems.ellandbasicitem;

import com.elland.controller.ellandcommon.utils.InvManager;
import com.elland.controller.ellandcommon.utils.Serializer;
import com.elland.rpgsystems.ellandbasicitem.databases.BasicItemDB;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EllandBasicItemAPI {
    /**
     * 설정된 기초 아이템 목록 배열 반환
     *
     * @return 기초 아이템 목록
     */
    public static List<ItemStack> getBasicItemList() {
        List<ItemStack> itemList = new ArrayList<>();
        for (Document doc : BasicItemDB.findList()) {
            String item64 = doc.getString("item_stack");
            ItemStack itemStack = Serializer.itemFrom64NoEx(item64);
            itemList.add(itemStack);
        }
        return itemList;
    }

    /**
     * 기초 아이템 설정 메뉴 열기
     *
     * @param p - 메뉴를 열 대상 플레이어
     */
    public static void openItemSettingMenu(Player p) {
        Main main = Main.getPlugin(Main.class);
        List<ItemStack> itemStackList = getBasicItemList();
        Inventory inv = InvManager.createInventory(p, 54, main.getMsg("S00004"));
        for (int i = 0; i < itemStackList.size(); i++) inv.setItem(i, itemStackList.get(i));
        p.openInventory(inv);
    }
}
