package com.example.frogwikibot.cofiguration;

import com.example.frogwikibot.telegram.FrogWikiBot;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Scheduler {

    private final FrogWikiBot bot;

    public Scheduler(FrogWikiBot bot) {
        this.bot = bot;
    }

    @Scheduled(cron = "${time.schedule}", zone = "Europe/Moscow")
    public void doIt() {
        bot.sendScheduledMessage();
    }
}
