package com.wayv.godly.manager;

import com.wayv.godly.CentralConfig;
import com.wayv.godly.command.CommandIndex;
import com.wayv.godly.interfaces.ICommand;
import discord4j.core.event.domain.message.MessageCreateEvent;

public class EventManager {
    private static final CentralConfig config = new CentralConfig();

    public static void initGatewayMessage(MessageCreateEvent event) {
        var message = event.getMessage();
        final String content = message.getContent();
        final String[] args = content.split(" ");
        final String firstArg = args[0];

        for (ICommand command : CommandIndex.getAllCommands()) {
            if (firstArg.equalsIgnoreCase(config.prefix + command.getName())) {
                command.initOnRun(event);
                break;
            }
        }
    }
}
