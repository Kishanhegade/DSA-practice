package map;

import java.util.*;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if(!mp.containsKey(sortedString))
            {
                mp.put(sortedString, new ArrayList<>());
            }
            mp.get(sortedString).add(str);
        }
        return new ArrayList<>(mp.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(strs);
        System.out.println(groupedAnagrams);

    }
}
