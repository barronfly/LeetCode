/**
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true


解题关键点有3个：

1. 找出word abbreviation 的规律，<first letter><number><last letter>，number = string.length() - 2

2. 当发现dictionary 里有相同的abbreviation, key 对应的value 变为"" 

3. The abbreviation of "hello", i.e., h3o already exists in the dictionary.
Input: ["hello"],isUnique("hello") Output: [false] Expected: [true]
If the given word itself is in the dictionary, and it has the unique abbreviation, then we should return true.

*/

public class ValidWordAbbr {
    private Map<String, String> map = HashMap<String, String>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
            String key = abbreviate(s);
            if(!map.containsKey(key))
                map.put(key, s);
            else
                map.put(key, "");
        }
    }
    
    private String abbreviate(String str) {
        if(str.length() < 3) return str;
        return str.substring(0,1) + String.valueOf(str.length()-2) + str.substring(s.length()-1);
    }
    
    public boolean isUnique(String word) {
        String x = abbreviate(word);
        if(map.containsKey(x)) {
            if(map.get(x).equals(word))
                return true;
            else
                return false;
        }
        return true;
    }
}
