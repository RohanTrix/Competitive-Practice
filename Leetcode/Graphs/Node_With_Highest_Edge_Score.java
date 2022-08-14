public class Node_With_Highest_Edge_Score {
    // IDEA : Create a score array(similar to indegree)...find the first node with the max score at the end
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long score[] = new long[n];
        
        for(int i = 0; i<n; i++)
            score[edges[i]]+=i;
        
        long maxNode = 0, maxi = -1;
        for(int i = 0; i<n; i++)
            if(maxi<score[i])
            {
                maxNode = i;
                maxi = score[i];
            }
        return (int)maxNode;
    }
}
