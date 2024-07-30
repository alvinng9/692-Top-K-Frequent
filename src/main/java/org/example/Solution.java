package org.example;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // create a map with String key word and Integer frequent
        HashMap<String, Integer> map = new HashMap<>();
        // go through the String array to add onto the map
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // create a priority queue that would put words that appear
        // the most first
        // if they appear the same amount, it would be based on alphabetical order
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> {
            int aNum = Integer.parseInt(a[1]);
            int bNum = Integer.parseInt(b[1]);
            // comparing appearances and alphabetical order
            if (aNum == bNum) {
                return a[0].compareTo(b[0]);
            } else {
                return bNum - aNum;
            }
        });

        // go through the map and add each word and its appearance to the priority queue
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }

        // create the result List
        List<String> result = new ArrayList<>();

        // add the most frequent k to the result List
        while (k > 0) {
            result.add(pq.remove()[0]);
            k--;
        }
        return result;
    }
}
