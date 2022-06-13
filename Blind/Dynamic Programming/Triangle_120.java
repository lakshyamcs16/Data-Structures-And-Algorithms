import java.util.*;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> t) {
        int res = t.get(0).get(0);
        int n = t.size();
        
        for(int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<=i; j++) {
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if(j - 1 >= 0) {
                    left = t.get(i-1).get(j-1) + t.get(i).get(j);
                }
                if(j < t.get(i-1).size()) {
                    right = t.get(i-1).get(j) + t.get(i).get(j);
                }
                int val = Math.min(left, right);
                t.get(i).set(j, val);
                min = Math.min(min, val);
            }
            res = min;
        }
        
        return res;
    }
}
