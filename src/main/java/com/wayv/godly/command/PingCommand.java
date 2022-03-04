package com.wayv.godly.command;

import com.wayv.godly.interfaces.ICommand;
import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.TimeZone;

public class PingCommand implements ICommand {
    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public void initOnRun(MessageCreateEvent event) {
        var channel = event.getMessage().getChannel().block();
        var now = TimeZone.
        if (channel != null) {
            var message = channel.createMessage("Ping?").block();
            if (message != null) {
                try {
                    channel.wait(3000);
                } catch (InterruptedException err) {
                    message.edit(spec -> spec.setContent("Uh... something went wrong...")).block();
                }
                channel.edit(spec -> )
            }
        }
    }
}
