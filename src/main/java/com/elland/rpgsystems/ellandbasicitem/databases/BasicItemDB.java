package com.elland.rpgsystems.ellandbasicitem.databases;

import com.elland.controller.ellandcommon.utils.Serializer;
import com.elland.rpgsystems.ellandbasicitem.Main;
import com.mongodb.client.MongoCollection;
import dev.elland.mongodb.controller.MongoController;
import org.bson.Document;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicItemDB {
    static final MongoCollection<Document> collection = MongoController.getDatabase()
            .getCollection(Objects.requireNonNull(Main.getPlugin(Main.class).getConfig().getString("collection_name")));

    /**
     * 기초 아이템 설정
     *
     * @param itemStackList - 설정할 기초 아이템 목록
     */
    public static void setList(List<ItemStack> itemStackList) {
        collection.deleteMany(new Document());
        for (ItemStack itemStack : itemStackList) {
            String item64 = Serializer.itemTo64(itemStack);
            collection.insertOne(new Document("item_stack", item64));
        }
    }

    /**
     * 데이터 모두 조회
     *
     * @return Document 배열
     */
    public static List<Document> findList() {
        return collection.find().into(new ArrayList<>());
    }
}
