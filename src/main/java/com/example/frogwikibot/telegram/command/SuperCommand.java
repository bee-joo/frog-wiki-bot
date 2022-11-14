package com.example.frogwikibot.telegram.command;

import com.example.frogwikibot.service.BotService;
import com.example.frogwikibot.telegram.keyboard.ReplyKeyboard;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@AllArgsConstructor
public abstract class SuperCommand {
    protected final BotService botService;
    protected final ReplyKeyboard replyKeyboard;

    public abstract SendMessage handle(String chatId);
}
