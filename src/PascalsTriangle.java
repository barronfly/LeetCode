/**
Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    // 算法时间复杂度应该是O(1+2+3+...+n)=O(n^2)
    // 空间上只需要二维数组来存储结果，不需要额外空间。
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0)
            return res;
        
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        
        for(int i=2; i<=numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j=0; j<pre.size()-1; j++) {
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);
            res.add(cur);
            pre = cur;
        }
        return res;
    }
}
