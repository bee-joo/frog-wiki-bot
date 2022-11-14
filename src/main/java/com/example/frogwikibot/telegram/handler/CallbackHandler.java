package com.example.frogwikibot.telegram.handler;

import com.example.frogwikibot.service.BotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
@AllArgsConstructor
public class CallbackHandler {

    private final BotService botService;

    public AnswerCallbackQuery handleSubscription(CallbackQuery callbackQuery) {
        String text;
        String chatId = callbackQuery.getMessage().getChatId().toString();
        String time = callbackQuery.getData();


        if (botService.isUserMember(time, chatId)) {
            text = "Вы подписаны на это же время";
        } else if (botService.isUserSubscriber(chatId)) {
            botService.unsubscribeUser(chatId);
            text = "Время изменено!";
        } else {
            text = "Подписка оформлена!";
        }

        botService.subscribeUser(time, chatId);

        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setCallbackQueryId(callbackQuery.getId());
        answerCallbackQuery.setText(text);

        return answerCallbackQuery;
    }

    public DeleteMessage editCallback(CallbackQuery callbackQuery) {
        String chatId = callbackQuery.getMessage().getChatId().toString();
        Integer messageId = callbackQuery.getMessage().getMessageId();

        return new DeleteMessage(chatId, messageId);
    }
}
