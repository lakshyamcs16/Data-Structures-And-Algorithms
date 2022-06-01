/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
 var findMedianSortedArrays = function(nums1, nums2) {
    let n1 = nums1.length; // will always be shorter
    let n2 = nums2.length;
    if (n1 > n2) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    let n  = n1 + n2;
    let left = 0, right = n1 - 1;
    
    while(true) {
        let x = Math.floor((left + right)/2);
        let y = Math.floor(n/2) - x - 2;
        
        let l1 = x < 0? Number.NEGATIVE_INFINITY : nums1[x];
        let r1 = x + 1 >= n1? Number.POSITIVE_INFINITY : nums1[x + 1];
        let l2 = y < 0? Number.NEGATIVE_INFINITY : nums2[y];
        let r2 = y + 1 >= n2? Number.POSITIVE_INFINITY : nums2[y + 1];
        
        if (l1 <= r2 && l2 <= r1) {
            if (n % 2 === 0) {
                return (Math.max(l1, l2) + Math.min(r1, r2))/2;
            }else{
                return (Math.min(r1, r2));
            }
        }else if(l1 > r2) {
            right = x - 1;
        }else{
            left = x + 1;
        }
    }
};