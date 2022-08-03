package Leetcode.Binary_Search;

public class My_Calendar_I {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() {
        tm = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // left is START of closest booked interval to the left
        // tm.get(left) is the END of that interval
        // If the END > start of query interval....then there is an overlap...e2 > s1
        //          s1     e1
        //          |------|
        //       |----|
        //       s2   e2
        Integer left = tm.floorKey(start);
        if(left !=null && tm.get(left) > start) return false;

        // right is START of closest booked interval to the right
        // If the end of current Interval > START....then there is an overlap...e1 > s2
        //          s1     e1
        //          |------|
        //               |----|
        //               s2   e2

        Integer right = tm.ceilingKey(start); 
        if(right !=null && end > right) return false;
        tm.put(start, end);
        return true;
    }
}
