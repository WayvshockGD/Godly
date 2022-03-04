package com.wayv.godly.interfaces;

import discord4j.core.event.domain.message.MessageCreateEvent;

public interface ICommand {
    public String getName();
    public void initOnRun(MessageCreateEvent event);
}
