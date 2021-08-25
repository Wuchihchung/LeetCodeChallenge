package com.leetcode.bryan.medium;

import java.util.HashMap;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        HashMap<String, Integer> secretMap = new HashMap<>();
        HashMap<String, Integer>guessMap = new HashMap<>();

        for (int idx = 0; idx < guess.length(); idx++) {
            String subSecret = secret.substring(idx, idx+1);
            String subGuess = guess.substring(idx, idx+1);

            if (subSecret.equals(subGuess))
                bulls++;
            else {
                //guessMap.put(subGuess, idx+1);
                Integer value1 = guessMap.getOrDefault(subGuess, -1);
                if (value1 >= 1) guessMap.put(subGuess, value1 + 1);
                else guessMap.put(subGuess, 1);

                //secretNew += subSecret;
                Integer value2 = secretMap.getOrDefault(subSecret, -1);
                if (value2 >= 1) secretMap.put(subSecret, value2 + 1);
                else secretMap.put(subSecret, 1);
            }
        }

        //System.out.println(secretMap);
        //System.out.println(guessMap);

        for (String s : guessMap.keySet()) {
            int value = secretMap.getOrDefault(s, -1);
            if (value != -1)
                cows += Math.min(value, guessMap.get(s));
        }

        //System.out.println(bulls + "A" + cows + "B");
        return bulls + "A" + cows + "B";
    }
}
