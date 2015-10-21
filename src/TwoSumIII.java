/**
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/

public class TwoSum {  
      
    HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();  
    public void add(int number) {  
       if(hashmap.containsKey(number)){  
           hashmap.put(number,hashmap.get(number)+1);  
       }else{  
           hashmap.put(number,1);  
       }  
    }  
  
    public boolean find(int value) {  
         for(Integer key: hashmap.keySet()){  
             if(hashmap.containsKey(value-key)){  
                 if(value == 2*key){  
                     return hashmap.get(key)>=2;  
                 }else{  
                     return true;  
                 }  
             }  
         }  
         return false;  
    }  
}  
