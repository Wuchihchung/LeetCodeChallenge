package com.leetcode.bryan.medium;

import java.util.*;


public class ReconstructItinerary {
    private static String tickets[][] = {{"JFK", "AAA"}, {"JFK", "BBB"}, {"BBB", "CCC"}, {"CCC", "JFK"}};

    private static HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    private static LinkedList<String> result = null;

    public static List<String> findItinerary() {
    // Step 1). build the graph first
        int size = tickets.length;

        for(String[] ticket : tickets) {
            String origin = ticket[0];
            String dest = ticket[1];

            if (flightMap.containsKey(origin)) {
                LinkedList<String> destList = flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                flightMap.put(origin, destList);
            }
        }

    // Step 2). order the destinations
        flightMap.forEach((key, value) -> Collections.sort(value));

        result = new LinkedList<String>();

    // Step 3). post-order DFS
        DFS("JFK");
        return result;
    }

    protected static void DFS(String origin) {
        // Visit all the outgoing edges first.
        if (flightMap.containsKey(origin)) {
            LinkedList<String> destList = flightMap.get(origin);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.

                String dest = destList.pollFirst();
                DFS(dest);
            }
        }

        // add the airport to the head of the itinerary
        result.offerFirst(origin);
    }
}
