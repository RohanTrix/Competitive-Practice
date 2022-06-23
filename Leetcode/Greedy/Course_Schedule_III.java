public class Course_Schedule_III {
    // REFER : https://youtu.be/q_EX4BV4-Cs
    // REFER : https://youtu.be/DjOU6ohtJ7o
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);

        int lastDay = 0, cnt = 0;
        for(int course[] : courses)
        {
            if(course[0] + lastDay <= course[1])
            {
                pq.offer(course);
                lastDay+=course[0];
            }
            else if(!pq.isEmpty() && pq.peek()[0] > course[0])
            {
                lastDay+=course[0] - pq.poll()[0];
                pq.offer(course);
            }
        }
        return pq.size();
    }
}
