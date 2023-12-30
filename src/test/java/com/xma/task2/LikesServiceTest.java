package com.xma.task2;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LikesServiceTest {
    LikesService likesService = new LikesService();

    {
        likesService.add("Степан: Рукоделие, зеленый чай, осень, иней, гулять");
        likesService.add("Петр: Программирование, кофе, осень, иней, гулять");
        likesService.add("Валисий: Программирование, зеленый чай, зима, иней, гулять");
    }


    @Test
    void getCommonLikes() {
        var commonLikes = likesService.getCommonLikes();
        Set<String> res = Set.of("гулять", "иней");
        assertEquals(res, commonLikes);
        System.out.println(commonLikes);
    }

    @Test
    void getAllLikes() {
        var allLikes = likesService.getAllLikes();
        Set<String> res = Set.of("гулять", "зеленый чай", "зима", "иней", "кофе", "осень", "программирование", "рукоделие");
        assertEquals(res, allLikes);
        System.out.println(allLikes);
    }

    @Test
    void getUniqueLikesForUser() {
        var likesForUser = likesService.getUniqueLikesForUser();
        var res = Map.of(
                "Валисий", Set.of("зима"),
                "Петр", Set.of("кофе"),
                "Степан", Set.of("рукоделие")
        );
        assertEquals(res, likesForUser);
        System.out.println(likesForUser);
    }

    @Test
    void getLikesCount() {
        var allLikes = likesService.getLikesCount();
        var res = Map.of(
                "иней", 3,
                "зеленый чай", 2,
                "рукоделие", 1,
                "осень", 2,
                "кофе", 1,
                "программирование", 2,
                "гулять", 3,
                "зима", 1
        );
        assertEquals(res, allLikes);
        System.out.println(allLikes);
    }
}