/*




*/

/*




*/

class Solution {
    public int maximumPopulation(int[][] logs) {
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int max = 0, year = 0;        
        for(int i=0; i<logs.length; i++) {
            int count = 0;
            for(int j=0; j<logs.length; j++) {
                if(logs[j][0] <= logs[i][0] && logs[j][1] > logs[i][0]) {
                    count++;
                }
            }
            if(count > max) {
                max = count;
                year = logs[i][0];
            }
        }
        
        return year;
    }
}
