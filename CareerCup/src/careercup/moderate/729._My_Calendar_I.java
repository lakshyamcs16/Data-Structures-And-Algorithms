/*

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.Example 1: Note: 


*/

/*

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.



*/

class MyCalendar {
​
    ArrayList<int[]> intervals;
    public MyCalendar() {
        intervals = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        int n = intervals.size();
        int[] key = new int[]{start, end};
        if(n == 0) {
            intervals.add(key);
            return true;
        }
        
        int id = binarySearch(0, n, n, key);
        
        if(id != -1) {
            intervals.add(id, new int[]{start, end});
            //print(id, new int[]{start, end});
            return true;
        }
        
        return false;
    }
    
    private void print(int id, int[] key) {
        for(int[] a:intervals) {
            System.out.print("["+a[0]+", "+a[1]+"]");
        }    
        System.out.println();
    }
    
    private int binarySearch(int s, int e, int n, int[] key) {
        if(s<e) {
            int mid = (s + e) / 2;
​
            if(mid - 1 < 0 && key[1] <= intervals.get(0)[0]) {
                return 0;
            }else if(mid + 1 >= n && intervals.get(n-1)[1] <= key[0]) {
                return n;
            }else if(mid - 1 >= 0 && intervals.get(mid-1)[1] <= key[0] && key[1] <= intervals.get(mid)[0]) {
                return mid;
            }else if(mid - 1 >= 0 && intervals.get(mid-1)[1] <= key[0] && key[1] < intervals.get(mid)[0]) {
                return mid - 1;
            }
            
            if(intervals.get(mid)[0] >= key[1]) {
                return binarySearch(s, mid, n, key);
            }
            
            return binarySearch(mid+1, e, n, key);
        }
​
        return -1;
    }
}
​
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
​
