// Helper Class:

class Pair {
	char ch;
	int freq;

	public void setFreq(int f) {
		freq = f;
	}

	public void setChar(char c) {
		ch = c;
	}

	public String toString() {
		return "("+ch+", "+freq + ")";
	}
}

// **Method 1: Sorting**


class Solution {
    
    public String reorganizeString(String s) {
        Pair[] pairs = new Pair[26];
        int n = s.length();
		
		StringBuilder res = new StringBuilder();
        pairs = buildFreqArr(pairs, s, n);
        
        int i=0, j=1;
        while(i<26 && j<26) {
            Pair chi = pairs[i];
            Pair chj = pairs[j];
            
            if(chi.freq > 0 && chj.freq > 0) {
                res.append(chi.ch).append(chj.ch);
                pairs[i].freq--; pairs[j].freq--;
            }else if(chi.freq > 0) {
                j++;
            }else{
                i = j;
                j++;
            }
            
            sortArray(pairs);
        }
        
        if (n%2 != 0) {
            res.append(pairs[i].ch);
            pairs[i].freq--;
        }
        
        return checkSum(pairs)? res.toString() : "";
    }
    
    private void sortArray(Pair[] pairs) {
        Arrays.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.freq - p1.freq;
            }
        });
    }
    
    private Pair[] buildFreqArr(Pair[] pairs, String s, int n) {
        for(int i=0; i<26; i++) {
            pairs[i] = new Pair();
        }
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            pairs[ch - 'a'].ch = ch;
            pairs[ch - 'a'].freq++; 
        }
    
        sortArray(pairs);
        
        return pairs;
    }
    
    private boolean checkSum(Pair[] pairs) {
        int sum = 0;
        for(int i=0; i<26; i++) {
            sum += pairs[i].freq;
        }
        return sum == 0;
    }
}


// **Method 2:** Using Priority Queue


class Solution {
	public String reorganizeString(String s) {
			Pair[] pairs = new Pair[26];
			int n = s.length();
			if(n == 1) return s;

			StringBuilder res = new StringBuilder();
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
				@Override
				public int compare(Pair p1, Pair p2) {
					return p2.freq - p1.freq;
				}
			});

			for(int i=0; i<26; i++) {
				pairs[i] = new Pair();
			}

			for(int i=0; i<n; i++) {
				char ch = s.charAt(i);
				pairs[ch - 'a'].ch = ch;
				pairs[ch - 'a'].freq++; 
			}

			for(int i=0; i<26; i++) {
				pq.offer(pairs[i]);
			}

			while(true) {
				Pair p1 = pq.poll();
				Pair p2 = pq.poll();
				if(p1.freq > 0 && p2.freq > 0) {
					res.append(p1.ch).append(p2.ch);
					p1.freq--; p2.freq--;
					pq.offer(p1);
					pq.offer(p2);
				}else if(n%2 != 0 && p1.freq > 1) {
					return "";
				}else if(n%2 != 0 && p1.freq == 1) {
					res.append(p1.ch);
					return res.toString();
				}else if(n%2 == 0 && p1.freq > 0) {
					return "";
				}else{
					return res.toString();
				}
			}
		}
}
