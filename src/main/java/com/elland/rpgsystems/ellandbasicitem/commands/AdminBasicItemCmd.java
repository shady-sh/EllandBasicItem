package com.elland.rpgsystems.ellandbasicitem.commands;

import com.elland.rpgsystems.ellandbasicitem.EllandBasicItemAPI;
import com.elland.rpgsystems.ellandbasicitem.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdminBasicItemCmd implements CommandExecutor {
    public static class TabComplete implements TabCompleter {
        private static final List<String> COMMANDS = Arrays.asList("reload", "open");

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
            }
            List<String> completions = new ArrayList<>();
            Collections.sort(completions);
            return completions;
        }
    }
    Main main = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            main.sendMsg(sender, "S00005", label);
            main.sendMsg(sender, "S00006", label);
            return true;
        }
        if (args[0].equals("open")) {
            if (!(sender instanceof Player)) {
                main.sendMsg(sender, "E00001");
                return true;
            }
            Player p = (Player) sender;
            EllandBasicItemAPI.openItemSettingMenu(p);
            return true;
        }
        if (args[0].equals("reload")) {
            main.reloadConfig();
            Main.langManager.reload();
            sender.sendMessage("§aConfig Successfully Reloaded!");
            return true;
        }
        return true;
    }
}
