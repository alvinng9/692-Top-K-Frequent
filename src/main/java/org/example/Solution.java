package org.example;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            int aNum = Integer.valueOf(a[1]);
            int bNum = Integer.valueOf(b[1]);
            if (aNum == bNum) {
                return a[0].compareTo(b[0]);
            } else {
                return bNum - aNum;
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        for (String here : words) {
            if(!map.containsKey(here)) {
                map.put(here, 0);
            }
            map.put(here, map.get(here) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.remove()[0]);
        }
        return result;
    }
}
