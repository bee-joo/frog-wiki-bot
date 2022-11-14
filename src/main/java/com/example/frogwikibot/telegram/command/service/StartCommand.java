package com.example.frogwikibot.telegram.command.service;

import com.example.frogwikibot.service.BotService;
import com.example.frogwikibot.telegram.command.SuperCommand;
import com.example.frogwikibot.telegram.keyboard.ReplyKeyboard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class StartCommand extends SuperCommand {
    public StartCommand(BotService botService, ReplyKeyboard replyKeyboard) {
        super(botService, replyKeyboard);
    }

    @Override
    public SendMessage handle(String chatId) {
        String text = "Привет! Я просто присылаю ссылку на Wikipedia со случайной лягушкой или жабой";
        SendMessage answer = new SendMessage(chatId, text);
        answer.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());

        return answer;
    }
}
