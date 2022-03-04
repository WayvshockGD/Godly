package com.wayv.godly;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import com.wayv.godly.manager.EventManager;

public class GodlyClient {
    public CentralConfig config = new CentralConfig();
    public DiscordClient instance;
    public GatewayDiscordClient gateway;

    public GodlyClient() {
        this.instance = DiscordClient.create(config.token);
        this.gateway = this.instance.login().block();

        if (this.gateway != null) {
            this.gateway.on(MessageCreateEvent.class).subscribe(EventManager::initGatewayMessage);
            this.gateway.onDisconnect().block();
        }
    }
}
