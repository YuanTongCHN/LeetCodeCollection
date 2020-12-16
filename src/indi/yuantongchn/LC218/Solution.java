package indi.yuantongchn.LC218;

//218. 天际线问题

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int len = buildings.length;
        if(len == 0){
            return res;
        }
        HashSet<Integer> mapSteps = new HashSet<>();
        HashMap<Integer, List<Integer>> mapAdd = new HashMap<>();
        HashMap<Integer, List<Integer>> mapRemove = new HashMap<>();
        for (int i = 0; i < len; i++) {
            mapSteps.add(buildings[i][0]);
            mapSteps.add(buildings[i][1]);
            if(!mapAdd.containsKey(buildings[i][0])){
                List<Integer> temp = new ArrayList<>();
                temp.add(buildings[i][2]);
                mapAdd.put(buildings[i][0], temp);
            }else {
                mapAdd.get(buildings[i][0]).add(buildings[i][2]);
            }
            if(!mapRemove.containsKey(buildings[i][1])){
                List<Integer> temp = new ArrayList<>();
                temp.add(buildings[i][2]);
                mapRemove.put(buildings[i][1], temp);
            }else {
                mapRemove.get(buildings[i][1]).add(buildings[i][2]);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(0);
        Object[] stepsTemp = mapSteps.toArray();
        int[] steps = new int[stepsTemp.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = (int) stepsTemp[i];
        }
        Arrays.sort(steps);
        for (int step : steps){
            boolean isChange = false;
            int lastHeight = queue.peek();
            if(mapAdd.containsKey(step)){
                List<Integer> temp = mapAdd.get(step);
                for (int height : temp) {
                    queue.add(height);
                }
                if(queue.peek() != lastHeight){
                    isChange = true;
                }
            }
            if(mapRemove.containsKey(step)){
                List<Integer> temp = mapRemove.get(step);
                for (int height : temp) {
                    queue.remove(height);
                }
                if(queue.peek() != lastHeight){
                    isChange = true;
                }
            }
            if(isChange){
                List<Integer> temp = new ArrayList<>();
                temp.add(step);
                temp.add(queue.peek());
                res.add(temp);
            }
        }
        return res;
    }
}
