# frog-wiki-bot

This bot can send random Wiki article about frog. You can subscribe for a daily frog :)  
[The same](https://github.com/bee-joo/bird-wiki-bot), but about frogs  
https://t.me/frog_wiki_bot

## Features
- Random link - Wiki has some categories about birds, so first bot pick random category, then Wiki sends random page in this category
- Daily subscription - Redis stores data as keys of hours and values of set with subscribers' chat ids. Every day at hours set in app properties bot executes sending messages using Spring scheduler
- User can choose hour (now are 8:00, 12:00, 18:00, 22:00), unsubscribe or change time

## Stack
- Java 17 ([Amazon Corretto](https://aws.amazon.com/corretto/) on server)
- [Telegram Bots Java Library](https://github.com/rubenlagus/TelegramBots) - Telegram API and classes
- [Spring Boot](https://spring.io/projects/spring-boot) - DI, IoC-container and beans configuring
- [Redis](https://redis.io/) - database
- [Spring Data Redis](https://github.com/spring-projects/spring-data-redis) - data access
- [Unirest](http://kong.github.io/unirest-java/) - HTTP client for fetching Wiki links
- [Lombok](https://projectlombok.org/) - boilerplate code generation
- [Apache Maven](https://maven.apache.org/) - build system and dependency management

## How to run
1. Set up bot using [BotFather](https://t.me/BotFather)
2. Set up Redis database
3. Change [application.yml](https://github.com/bee-joo/bird-wiki-bot/blob/main/src/main/resources/application.yml) for bot token and database config
4. ```mvnw clean package -DskipTests && java -jar [jar_name].jar --spring.config.location=file:///[location of application.yml]```
