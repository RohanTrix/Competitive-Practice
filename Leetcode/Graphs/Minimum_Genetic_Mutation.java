public class Minimum_Genetic_Mutation
{
    // IDEA : USE BFS....one important implementation trick was to check current string with each string in bank
    //        and if they have only 1 position of difference AND has not been visited yet(can be checked using distance map)
    //        then add it to the queue. This is better than changing each character to the other 3 possibilities and building a string
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        q.offer(start);
        while(!q.isEmpty())
        {
            String curr = q.poll();
            if(curr.equals(end))
                return dist.get(end);
            char str[] = curr.toCharArray();
            for(String s : bank)
            {
                int skip = 0;
                for(int i = 0; i<8; i++)
                    if(str[i] != s.charAt(i))
                        skip++;
                if(skip == 1 && !dist.containsKey(s))
                {
                    dist.put(s, dist.get(curr)+1);
                    q.offer(s);
                }
            }
        }
        return -1;
    }
}