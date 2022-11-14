package com.example.frogwikibot.service;

import java.util.Optional;
import java.util.Set;

public interface BotService {

    Optional<String> getWikiLink();
    String randomLinkText();
    boolean isUserSubscriber(String chatId);
    void subscribeUser(String time, String chatId);
    void unsubscribeUser(String chatId);
    Set<String> getUsersByTime(String time);
    boolean isUserMember(String time, String chatId);
}
