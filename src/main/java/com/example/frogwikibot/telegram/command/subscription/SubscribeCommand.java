package com.example.frogwikibot.telegram.command.subscription;

import com.example.frogwikibot.service.BotService;
import com.example.frogwikibot.telegram.command.SuperCommand;
import com.example.frogwikibot.telegram.keyboard.InlineKeyboard;
import com.example.frogwikibot.telegram.keyboard.ReplyKeyboard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class SubscribeCommand extends SuperCommand {

    private final InlineKeyboard inlineKeyboard;

    public SubscribeCommand(BotService botService, ReplyKeyboard replyKeyboard, InlineKeyboard inlineKeyboard) {
        super(botService, replyKeyboard);
        this.inlineKeyboard = inlineKeyboard;
    }

    @Override
    public SendMessage handle(String chatId) {
        SendMessage answer = new SendMessage();
        answer.setChatId(chatId);

        String text;
        if (botService.isUserSubscriber(chatId)) {
            text = "Вы уже подписаны";
            answer.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());
        } else {
            text = "Выберите время";
            answer.setReplyMarkup(inlineKeyboard.getTimeInlineKeyboard());
        }

        answer.setText(text);
        return answer;
    }
}
