package com.example.frogwikibot.category;

public enum Categories {
    ODORRANA("Odorrana"),
    CASCADE("Каскадницы"),
    BROWN("Бурые_лягушки"),
    GREEN("Зелёные_лягушки"),
    LITHOBATES("Lithobates"),
    BUFO("Жабы"),
    BUFO_R("Жабы_(род)");

    private final String name;

    Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
