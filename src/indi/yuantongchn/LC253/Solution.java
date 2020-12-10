package indi.yuantongchn.LC253;

//253. 会议室 II

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    //优先队列
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int len = intervals.length;
        int count = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for(int i=0;i<len;i++){
            if(endTimes.isEmpty() || endTimes.peek() > intervals[i][0]){
                count++;
                endTimes.add(intervals[i][1]);
            }else{
                endTimes.poll();
                endTimes.add(intervals[i][1]);
            }
        }
        return count;
    }


/*    //双指针法
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int len = intervals.length;
        int[] startTimes = new int[len];
        int[] endTimes = new int[len];
        for (int i = 0; i < len; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int startFlag = 0;
        int endFlag = 0;
        int count = 0;
        while (startFlag < len) {
            if (startTimes[startFlag] < endTimes[endFlag]) {
                count++;
                startFlag++;
            } else {
                startFlag++;
                endFlag++;
            }
        }
        return count;
    }*/
}
