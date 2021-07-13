```java
class Pair implements Comparable<Pair>
{
    int st;
    int end;
    public Pair(int start, int e)
    {
        st = start;
        end = e;
    }
    
    @Override
    public int compareTo(Pair p)
    {
       return Integer.compare(end, p.end);
        
    }
    public String toString()
    {
        return st+ " "+end;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Pair> al = new ArrayList<>();
        for(int i = 0; i<n;i++)
        {
            al.add(new Pair(start[i], end[i]));
        }
        Collections.sort(al);
        //System.out.println(al);
        int cnt = 1;
        int curr_st = al.get(0).st;
        int curr_end = al.get(0).end;
        for(int i =1; i<n;i++)
        {
            int st = al.get(i).st;
            int e = al.get(i).end;
            if(curr_end < st)
            {
                cnt++;
                curr_st = st;
                curr_end = e;
            }
        }
        return cnt;
    }
}
```