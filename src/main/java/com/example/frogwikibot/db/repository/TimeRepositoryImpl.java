package com.example.frogwikibot.db.repository;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class TimeRepositoryImpl implements TimeRepository {

    private final SetOperations<String, String> setOps;
    private static final String CHAT_IDS_KEY = "FrogTime:%s:chatIds";
    private static final String KEY = "FrogTime";

    public TimeRepositoryImpl(StringRedisTemplate template) {
        this.setOps = template.opsForSet();
    }

    @Override
    public Set<String> getChatIdsByTime(String time) {
        return setOps.members(String.format(CHAT_IDS_KEY, time));
    }

    @Override
    public Long putChatId(String time, String chatId) {
        return setOps.add(String.format(CHAT_IDS_KEY, time), chatId);
    }

    @Override
    public Long putTime(String time) {
        return setOps.add(KEY, time);
    }

    @Override
    public Boolean isChatIdMember(String time, String chatId) {
        return setOps.isMember(String.format(CHAT_IDS_KEY, time), chatId);
    }

    @Override
    public Long removeChatId(String time, String chatId) {
        return setOps.remove(String.format(CHAT_IDS_KEY, time), chatId);
    }

    @Override
    public Long removeTime(String time) {
        return setOps.remove(KEY, time);
    }
}
