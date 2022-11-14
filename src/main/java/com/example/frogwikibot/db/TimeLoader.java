package com.example.frogwikibot.db;

import com.example.frogwikibot.db.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TimeLoader {

    @Value("${time.hours}")
    private final List<String> hours = new ArrayList<>();
    private final TimeRepository timeRepository;

    public TimeLoader(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @PostConstruct
    public void loadData() {
        hours.forEach(timeRepository::putTime);
    }
}
