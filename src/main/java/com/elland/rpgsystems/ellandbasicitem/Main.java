package com.elland.rpgsystems.ellandbasicitem;

import com.elland.controller.ellandcommon.utils.LangManager;
import com.elland.rpgsystems.ellandbasicitem.commands.AdminBasicItemCmd;
import com.elland.rpgsystems.ellandbasicitem.eventhandler.EtcEvents;
import com.elland.rpgsystems.ellandbasicitem.eventhandler.InvEvents;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    public static LangManager langManager;

    @Override
    public void onEnable() {
        langManager = new LangManager(this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        Objects.requireNonNull(getCommand("기초템관리")).setExecutor(new AdminBasicItemCmd());
        Objects.requireNonNull(getCommand("기초템관리")).setTabCompleter(new AdminBasicItemCmd.TabComplete());
        getServer().getPluginManager().registerEvents(new InvEvents(), this);
        getServer().getPluginManager().registerEvents(new EtcEvents(), this);
    }

    @Override
    public void onDisable() {}

    private String replaceVariables(String message, Object... variables) {
        for (int i = 0; i < variables.length; i++) {
            message = message.replace("{" + i + "}", String.valueOf(variables[i]));
        }
        return message;
    }

    // 메시지 보내기
    public void sendMsg(CommandSender sender, String messageType, Object... variables) {
        String message = langManager.getMessage(getConfig().getString("system_language"), messageType);
        message = this.replaceVariables(message, variables);
        sender.sendMessage(message);
    }

    // 전체메시지 보내기
    public void broadcast(String messageType, Object... variables) {
        String message = langManager.getMessage(getConfig().getString("system_language"), messageType);
        message = this.replaceVariables(message, variables);
        Bukkit.broadcastMessage(message);
    }

    // 메시지 반환
    public String getMsg(String messageType, Object... variables) {
        String message = langManager.getMessage(getConfig().getString("system_language"), messageType);
        message = this.replaceVariables(message, variables);
        return message;
    }
}
