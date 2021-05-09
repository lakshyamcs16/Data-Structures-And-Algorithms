/*




*/

/*




*/

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int dist = 0;
        
        int i=0, j=0;
        int m=nums1.length; int n=nums2.length;
        
        while(i<m && j<n) {
            dist = Math.max(dist, j - i - 1);
            
            if(nums1[i] > nums2[j]) {
                i++;
            }else{
                j++;
            }
        }
        
        dist = Math.max(dist, j - i - 1);
        return dist;
    }
}
