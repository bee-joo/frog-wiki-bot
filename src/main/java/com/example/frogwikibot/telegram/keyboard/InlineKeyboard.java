package com.example.frogwikibot.telegram.keyboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class InlineKeyboard {

    @Value("${time.hours}")
    private final List<String> hours = new ArrayList<>();

    public InlineKeyboardMarkup getTimeInlineKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> buttonList = new ArrayList<>();
        hours.forEach(hour -> buttonList.add(InlineKeyboardButton.builder()
                        .text(hour + ":00")
                        .callbackData(hour)
                        .build()));

        inlineKeyboardMarkup.setKeyboard(Collections.singletonList(buttonList));
        return inlineKeyboardMarkup;
    }
}
