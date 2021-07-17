class Solution:
    '''
    A classic greedy case: interval scheduling problem.

The heuristic is: always pick the interval with the earliest end time. 
Then you can get the maximal number of non-overlapping intervals. (or minimal number to remove).
This is because, the interval with the earliest end time produces the maximal capacity to hold rest intervals.
E.g. Suppose current earliest end time of the rest intervals is x. 
Then available time slot left for other intervals is [x:]. If we choose another interval with end time y, 
then available time slot would be [y:]. Since x ≤ y, there is no way [y:] can hold 
more intervals then [x:]. Thus, the heuristic holds.
Therefore, we can sort interval by ending time and key track of 
current earliest end time. Once next interval's start time is earlier than current end time,
 then we have to remove one interval. Otherwise, we update earliest end time.
    '''
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        
        end, cnt = float('-inf'), 0
        l = sorted(intervals, key=lambda x: x[1])
        for s, e in l:
            if s>=end:
                end = e
            else:
                cnt+=1
        return cnt