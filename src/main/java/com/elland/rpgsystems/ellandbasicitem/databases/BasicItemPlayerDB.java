package com.elland.rpgsystems.ellandbasicitem.databases;

import com.elland.controller.ellandcommon.utils.TimeUtil;
import com.elland.rpgsystems.ellandbasicitem.Main;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import dev.elland.mongodb.controller.MongoController;
import org.bson.Document;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;

public class BasicItemPlayerDB {
    static final MongoCollection<Document> collection = MongoController.getDatabase()
            .getCollection(Objects.requireNonNull(Main.getPlugin(Main.class).getConfig().getString("player_collection_name")));

    /**
     * 플레이어 데이터 생성
     *
     * @param p - 플레이어
     */
    public static void create(Player p) {
        UUID uuid = p.getUniqueId();
        String playerName = p.getName();
        if (findOne(uuid) != null) {
            updateOne(uuid, "player_name", p.getName());
            return;
        }
        Document newUser = new Document("uuid", uuid.toString())
                .append("player_name", playerName)
                .append("first_join_dt", TimeUtil.getCurrentKSTDate());
        collection.insertOne(newUser);
    }

    /**
     * 플레이어 Document 데이터 반환
     *
     * @param uuid - 해당 플레이어의 UUID
     */
    public static Document findOne(UUID uuid) {
        return collection.find(Filters.eq("uuid", uuid.toString())).first();
    }

    /**
     * 플레이어 DB 업데이트
     *
     * @param uuid  - 플레이어 UUID
     * @param key   - 바꿀 대상의 Key
     * @param value - 해당 key 에 대한 value 값
     */
    public static <T> void updateOne(UUID uuid, String key, T value) {
        try {
            collection.updateOne(Filters.eq("uuid", uuid.toString()),
                    Updates.combine(Updates.set(key, value),
                            Updates.set("update_dt", TimeUtil.getCurrentKSTDate())));
        } catch (MongoException mongoException) {
            System.err.println("Unable to update due to an error: " + mongoException);
        }
    }
}
