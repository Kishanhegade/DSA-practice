package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        Map<Character,Integer> mp = new LinkedHashMap<>();
        for(char ch:charArray)
        {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
