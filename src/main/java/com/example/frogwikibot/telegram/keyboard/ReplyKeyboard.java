package com.example.frogwikibot.telegram.keyboard;

import com.example.frogwikibot.telegram.command.CommandNames;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;
import java.util.List;

@Component
public class ReplyKeyboard {
    public ReplyKeyboardMarkup getMainReplyKeyboard() {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton(CommandNames.RANDOM_COMMAND.getKey()));
        keyboardRow.add(new KeyboardButton(CommandNames.SUBSCRIPTION_MENU.getKey()));

        return defaultKeyboardSettings(Collections.singletonList(keyboardRow));
    }

    public ReplyKeyboardMarkup getSubscribeReplyKeyboard() {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton(CommandNames.BACK_COMMAND.getKey()));
        keyboardRow.add(new KeyboardButton(CommandNames.SUBSCRIBE_COMMAND.getKey()));

        return defaultKeyboardSettings(Collections.singletonList(keyboardRow));
    }

    public ReplyKeyboardMarkup getChangeStatusReplyKeyboard() {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton(CommandNames.BACK_COMMAND.getKey()));
        keyboardRow.add(new KeyboardButton(CommandNames.CHANGE_TIME_COMMAND.getKey()));
        keyboardRow.add(new KeyboardButton(CommandNames.UNSUBSCRIBE_COMMAND.getKey()));

        return defaultKeyboardSettings(Collections.singletonList(keyboardRow));
    }

    private ReplyKeyboardMarkup defaultKeyboardSettings(List<KeyboardRow> keyboardRows) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardRows);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;
    }
}
