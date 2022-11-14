package com.example.frogwikibot.db.repository;

import java.util.Set;

public interface TimeRepository {
    Set<String> getChatIdsByTime(String time);
    Long putChatId(String time, String chatId);
    Long putTime(String time);
    Boolean isChatIdMember(String time, String chatId);
    Long removeChatId(String time, String chatId);
    Long removeTime(String time);
}
