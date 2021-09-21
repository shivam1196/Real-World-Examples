package com.shivam.realworldexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Suppose the content library contains the following titles: "duel", "dule", "speed", "spede", "deul", "cars".
How would you efficiently implement a functionality so that if a user misspells speed as spede,kmo098uy789
they are shown the correct title
 */
public class GroupSimilarTitles {
    public static List<List<String>> groupTitles(String[] titles){
        HashMap<String,List<String>> titleMap = new HashMap<>();

        int count[] = new int[26];

        for(String s: titles){
            Arrays.fill(count,0);
            for(char c : s.toCharArray()){
                int index = c - 'a';
                count[index]++;
            }

            StringBuilder stringBuilder = new StringBuilder("");

            for(int i =0;i<26;i++){
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String key = stringBuilder.toString();

            if(!titleMap.containsKey(key)){
                titleMap.put(key,new ArrayList<>());
            }

            titleMap.get(key).add(s);
        }

        return new ArrayList<List<String>>(titleMap.values());
    }

    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel","dule","speed","spede","deul","cars"};

        List<List<String>> gt = groupTitles(titles);
        String query = "duel";

        // Searching for all titles
        for (List<String> g : gt){
            if (g.contains(query))
                System.out.println(g);
        }
    }
}
