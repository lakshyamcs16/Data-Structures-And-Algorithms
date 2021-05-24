/*

Given a non-empty list of words, return the k most frequent elements.Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.Example 1:
Example 2:
Note:
Follow up:



*/

/*

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.



*/

/*
    Report:
        Time: Beats 99.78% | O(nlogk)
        Space: Beats 17.64% | O(n)
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       Map<String, Integer> map = new HashMap<String, Integer>();
       List<String> ans = new ArrayList<String>();
       Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(k,
           new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2) {
                        if (p1.getValue() < p2.getValue()) {
                            return 1;
                        } else if (p1.getValue() > p2.getValue()) {
                            return -1;
                        } else {
                           return p1.getKey().compareTo(p2.getKey());   
                        }
                    }
            });
        
        for(String word:words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        
        while(k-->0 && pq.size() > 0) {
            ans.add(pq.poll().getKey());
        }
        
        return ans;
    }
}
​
