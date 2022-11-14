package com.example.frogwikibot.category;

import java.util.*;

public class RandomCategory {
    private static final List<Categories> values = Arrays.asList(Categories.values());
    private static final Random random = new Random();

    private static final List<Categories> rareCategories = List.of(Categories.CASCADE, Categories.BUFO_R, Categories.LITHOBATES);
    private static final List<Categories> restCategories = values.stream()
            .filter(e -> !rareCategories.contains(e))
            .toList();

    public static String getRandomCategory() {
        int num = random.nextInt(100 + 1);

        if (num < 3) {
            return getRandomFromList(rareCategories).getName();
        }

        return getRandomFromList(restCategories).getName();
    }

    private static Categories getRandomFromList(List<Categories> categories) {
        int size = categories.size();
        return categories.get(random.nextInt(size));
    }
}
