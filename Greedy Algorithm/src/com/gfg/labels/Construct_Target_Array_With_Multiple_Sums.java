/*

Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :
Return True if it is possible to construct the target array from A otherwise return False.
 
Example 1:
Example 2:
Example 3:
 
Constraints:


*/

/*

Input: target = [9,3,5]
Output: true
Explanation: Start with [1, 1, 1] 
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done

Input: target = [1,1,1,2]
Output: false
Explanation: Impossible to create target array from [1,1,1,1].

Input: target = [8,5]
Output: true



*/

class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0, n = target.length;
        if(n == 1) return target[0] == 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            pq.offer(target[i]);
            sum += target[i];
        }
​
        while(sum > 1 && pq.peek() > sum / 2) {
            int max = pq.poll();
            sum = sum - max;
            
            if (sum <= 1) return sum == 0 ? false : true;
            
            pq.add(max % (int)sum);
            sum += max % sum;
        }
        
        return n == sum;
    }
}
