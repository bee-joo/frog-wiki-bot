package com.example.frogwikibot.telegram.handler;

import com.example.frogwikibot.telegram.command.Menu;
import com.example.frogwikibot.telegram.keyboard.ReplyKeyboard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@AllArgsConstructor
public class MessageHandler {

    private final ReplyKeyboard replyKeyboard;
    private final Menu menu;

    public SendMessage router(String route, String chatId) {

        if (menu.containsKey(route)) {
            return menu.get(route).handle(chatId);
        } else {
            String text = "Я не понял ваше желание";
            return getSimpleMessage(chatId, text);
        }
    }

    public SendMessage getSimpleMessage(String chatId, String text) {
        SendMessage message = new SendMessage(chatId, text);
        message.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());

        return message;
    }
}
