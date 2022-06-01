// https://www.lintcode.com/problem/919/

/*
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.)

Contact me on wechat to get Amazon、Google requent Interview questions . (wechat id : jiuzhang15)


(0,8),(8,10) is not conflict at 8

Example
Example1

Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)
Example2

Input: intervals = [(2,7)]
Output: 1
Explanation: 
Only need one meeting room
*/

/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

export class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */

    minMeetingRooms(intervals) {
        // Write your code here
        const starts = intervals.map(i => i.start).sort((x, y) => x - y);
        const ends = intervals.map(i => i.end).sort((x, y) => x - y);

        let i = 0, j = 0;
        let rooms = 0, res = 0;

        while (i < starts.length && j < ends.length) {
            if (starts[i] < ends[j]) {
                rooms++;
                i++;
            } else {
                rooms--;
                j++;
            }

            res = Math.max(res, rooms);
        }

        return res;
    }
}