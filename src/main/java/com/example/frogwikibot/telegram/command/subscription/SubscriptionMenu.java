package com.example.frogwikibot.telegram.command.subscription;

import com.example.frogwikibot.service.BotService;
import com.example.frogwikibot.telegram.command.SuperCommand;
import com.example.frogwikibot.telegram.keyboard.ReplyKeyboard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class SubscriptionMenu extends SuperCommand {

    public SubscriptionMenu(BotService botService, ReplyKeyboard replyKeyboard) {
        super(botService, replyKeyboard);
    }

    @Override
    public SendMessage handle(String chatId) {
        String text = "Что желаете сделать?";

        SendMessage answer = new SendMessage(chatId, text);
        answer.setReplyMarkup(botService.isUserSubscriber(chatId)
                ? replyKeyboard.getChangeStatusReplyKeyboard()
                : replyKeyboard.getSubscribeReplyKeyboard());

        return answer;
    }
}
