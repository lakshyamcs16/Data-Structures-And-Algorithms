import java.util.*;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<Integer>();
        int last = 0;
        int first = -1;
        int n = s.length();
        
        int[] pos = new int[26];
        
        for(int i=0; i<n; i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            int index = pos[ch - 'a'];
            last = Math.max(last, index);
            
            if (i == last) {
                res.add(i - first);
                first = i;
            }
        }
        
        return res;
    }
}
