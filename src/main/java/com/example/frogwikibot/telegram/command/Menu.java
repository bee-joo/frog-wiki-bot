package com.example.frogwikibot.telegram.command;

import com.example.frogwikibot.telegram.command.service.BackCommand;
import com.example.frogwikibot.telegram.command.service.RandomCommand;
import com.example.frogwikibot.telegram.command.service.StartCommand;
import com.example.frogwikibot.telegram.command.subscription.ChangeTimeCommand;
import com.example.frogwikibot.telegram.command.subscription.SubscribeCommand;
import com.example.frogwikibot.telegram.command.subscription.SubscriptionMenu;
import com.example.frogwikibot.telegram.command.subscription.UnsubscribeCommand;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Menu extends HashMap<String, SuperCommand> {

    public Menu(StartCommand startCommand,
                RandomCommand randomCommand,
                SubscriptionMenu subscriptionMenu,
                SubscribeCommand subscribeCommand,
                UnsubscribeCommand unsubscribeCommand,
                ChangeTimeCommand changeTimeCommand,
                BackCommand backCommand) {

        put(CommandNames.START_COMMAND.getId(), startCommand);
        put(CommandNames.RANDOM_COMMAND.getId(), randomCommand);
        put(CommandNames.RANDOM_COMMAND.getKey(), randomCommand);
        put(CommandNames.SUBSCRIPTION_MENU.getId(), subscriptionMenu);
        put(CommandNames.SUBSCRIPTION_MENU.getKey(), subscriptionMenu);
        put(CommandNames.SUBSCRIBE_COMMAND.getKey(), subscribeCommand);
        put(CommandNames.UNSUBSCRIBE_COMMAND.getKey(), unsubscribeCommand);
        put(CommandNames.CHANGE_TIME_COMMAND.getKey(), changeTimeCommand);
        put(CommandNames.BACK_COMMAND.getKey(), backCommand);
    }
}
