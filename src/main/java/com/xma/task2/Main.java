package com.xma.task2;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        LikesService likesService = new LikesService();
        //consoleInput(likesService);
        testInput(likesService);

        System.out.println("Введенные данные");
        printMap(likesService.getLikes());

        System.out.println("всеобщие \"любимки\" - что нравится каждому из пользователей");
        printSet(likesService.getCommonLikes());
        System.out.println("все \"любимки\" - что нравится хотя бы одному из пользователей;");
        printSet(likesService.getAllLikes());
        System.out.println("для каждого пользователя - что ему нравится, а всем остальным нет;");
        printMap(likesService.getUniqueLikesForUser());
        System.out.println("для каждой «любимки» - скольки пользователям она нравится");
        printMap(likesService.getLikesCount());
    }

    private static void testInput(LikesService likesService) {
        likesService.add("Степан: Рукоделие, зеленый чай, осень, иней, гулять");
        likesService.add("Петр: Программирование, кофе, осень, иней, гулять");
        likesService.add("Валисий: Программирование, зеленый чай, зима, иней, гулять");
    }

    private static void consoleInput(LikesService likesService) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();
            if (input.isEmpty()) break;
            likesService.add(input);
        }
    }


    private static <T> void printMap(Map<String, T> map) {
        map.forEach((key, val) -> System.out.printf("\t- %17s -> %s%n", key, val));
        System.out.println();
    }

    private static void printSet(SortedSet<String> set) {
        set.forEach(x -> System.out.println("\t- " + x));
        System.out.println();
    }
}
