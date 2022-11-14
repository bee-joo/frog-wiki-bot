package com.example.frogwikibot.service;

import com.example.frogwikibot.category.RandomCategory;
import com.example.frogwikibot.db.repository.TimeRepository;
import kong.unirest.Unirest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class BotServiceImpl implements BotService {

    private final TimeRepository timeRepository;

    private static final String url = "https://ru.wikipedia.org/wiki/Служебная:RandomInCategory/";

    @Value("${time.hours}")
    private final List<String> hours = new ArrayList<>();

    @Override
    public Optional<String> getWikiLink() {
        try {
            String result = Unirest.get(url + RandomCategory.getRandomCategory())
                    .asString()
                    .getHeaders()
                    .getFirst("location");
            return Optional.ofNullable(result);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            return Optional.empty();
        }
    }

    @Override
    public String randomLinkText() {
        Optional<String> wikiLink = getWikiLink();

        String text;
        if (wikiLink.isPresent()) {
            String gotLink = wikiLink.get();
            String[] splitLink = gotLink.split("/") ;

            text = '[' +
                    URLDecoder.decode(splitLink[splitLink.length - 1].replace('_', ' '), StandardCharsets.UTF_8) +
                    "](" + gotLink + ')';
        } else {
            log.warn("Something wrong with getting link");
            text = "Что-то пошло не так :(";
        }

        return text;
    }

    @Override
    public boolean isUserSubscriber(String chatId) {
        return hours.stream()
                .anyMatch(hour -> timeRepository.isChatIdMember(hour, chatId));
    }

    @Override
    public void subscribeUser(String time, String chatId) {
        timeRepository.putChatId(time, chatId);
    }

    @Override
    public void unsubscribeUser(String chatId) {
        hours.forEach(hour -> timeRepository.removeChatId(hour, chatId));
    }

    @Override
    public Set<String> getUsersByTime(String time) {
        return timeRepository.getChatIdsByTime(time);
    }

    @Override
    public boolean isUserMember(String time, String chatId) {
        return timeRepository.isChatIdMember(time, chatId);
    }
}
