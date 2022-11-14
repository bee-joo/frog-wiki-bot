package com.example.frogwikibot.telegram.command.service;

import com.example.frogwikibot.service.BotService;
import com.example.frogwikibot.telegram.command.SuperCommand;
import com.example.frogwikibot.telegram.keyboard.ReplyKeyboard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class RandomCommand extends SuperCommand {

    public RandomCommand(BotService botService, ReplyKeyboard replyKeyboard) {
        super(botService, replyKeyboard);
    }

    @Override
    public SendMessage handle(String chatId) {
        String text = botService.randomLinkText();

        SendMessage answer = new SendMessage(chatId, text);
        answer.enableMarkdown(true);
        answer.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());

        return answer;
    }
}
