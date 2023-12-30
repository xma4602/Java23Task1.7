package com.xma.task2;

import java.util.*;

public class LikesService {
    private final SortedMap<String, SortedSet<String>> likes;

    public LikesService() {
        likes = new TreeMap<>();
    }

    public SortedMap<String, SortedSet<String>> getLikes() {
        return likes;
    }


    public void add(String input) {
        String[] items = input.split(":");
        String key = items[0];
        items = items[1].split(",\\s*");
        SortedSet<String> value = new TreeSet<>();
        for (var item : items) {
            value.add(item.strip().toLowerCase());
        }
        likes.put(key, value);
    }

    /**
     * всеобщие "любимки" - что нравится каждому из пользователей;
     */
    public SortedSet<String> getCommonLikes() {
        SortedSet<String> result = new TreeSet<>(likes.get(likes.firstKey()));
        likes.values().forEach(result::retainAll);
        return result;
    }

    /**
     * все "любимки" - что нравится хотя бы одному из пользователей;
     */
    public SortedSet<String> getAllLikes() {
        SortedSet<String> result = new TreeSet<>();
        likes.values().forEach(result::addAll);
        return result;
    }

    /**
     * для каждого пользователя - что ему нравится, а всем остальным нет;
     */
    public SortedMap<String, SortedSet<String>> getUniqueLikesForUser() {
        SortedMap<String, SortedSet<String>> result = new TreeMap<>();

        for (Map.Entry<String, SortedSet<String>> userLikes : likes.entrySet()) {
            SortedSet<String> items = new TreeSet<>(userLikes.getValue());

            for (var value : likes.entrySet()) {
                if (value.getKey() != userLikes.getKey()) {
                    items.removeAll(value.getValue());
                }
            }

            result.put(userLikes.getKey(), items);
        }

        return result;
    }

    /**
     * для каждой «любимки» - скольки пользователям она нравится
     */
    public Map<String, Integer> getLikesCount() {
        Map<String, Integer> result = new HashMap<>();

        likes.values().stream()
                .flatMap(Collection::stream)
                .forEach(like -> result.merge(like, 1, (value, y) -> value + 1));

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        likes.entrySet().forEach(x -> builder.append(x.toString()).append("\n"));
        return builder.toString();
    }
}
