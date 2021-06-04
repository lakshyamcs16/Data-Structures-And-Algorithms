/*

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.The lock initially starts at '0000', a string representing the state of the 4 wheels.You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible. Example 1:Example 2:Example 3:Example 4: Constraints:


*/

/*

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Input: deadends = ["0000"], target = "8888"
Output: -1



*/

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<String>(Arrays.asList(deadends));
        
        if(visited.contains(target) || visited.contains("0000")) {
            return -1;
        }
        
        if("0000".equals(target)) {
            return 0;
        }
        
        int c = 0;
        Queue<String> q = new LinkedList<String>();
        String[][] next = new String[][] {
            {"9","1"}, {"0","2"}, {"1","3"}, {"2","4"}, {"3","5"}, {"4","6"}, {"5","7"}, {"6","8"}, {"7","9"}, {"8","0"}
        };
        
        q.offer("0000");
        visited.add("0000");
        q.offer(null);
        
        while(q.size() > 1) {
            String st = q.poll();
            
            if(st != null && st.equals(target)) {
                return c;
            }
            
            if(st == null) {
                c++;
                q.offer(null);
            }else{
                for(int i=0; i<4; i++) {
                    int id = st.charAt(i) - '0';
​
                    String s1 = st.substring(0, i) + next[id][1] + st.substring(i+1);
                    String s2 = st.substring(0, i) + next[id][0] + st.substring(i+1);
                    
                    if(!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
            }
        }
        
        return -1;
    }
​
}
​
