// nlog n Binary Search based approach
// REFER FOR LOGIC : https://youtu.be/G5wLN4UweAM
public class Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int count(int key, int mat[][])
    {
        int m = mat.length, n = mat[0].length;
        int cnt = 0, r = 0, c = n-1;
        while(r<m && c>=0)
        {
            if(mat[r][c]<=key)
            {
                cnt+=(c+1);
                r++;
            }
            else
                c--;
        }
        // System.out.println("Key ="+key+" cnt="+cnt);
        return cnt;
    }
    public int kthSmallest(int[][] mat, int k) {
        // Think of problem as k row no. of sorted lists
        int m = mat.length, n = mat[0].length;
        
        int left = mat[0][0], right = mat[m-1][n-1];
        int ans = -1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(count(mid, mat)>=k)
            {
                ans = mid;
                right = mid - 1;
            }
            else 
                left = mid + 1;
        }
        return ans;
    }
}

class Kth_Smallest_Element_in_a_Sorted_Matrix1
{
    public int kthSmallest(int[][] mat, int k) {
        // Related the problem to Merge K Sorted Lists
        // We put the first cell coordinate of every row into the priorityqueue
        // and then keep on popping minimum and inserting next element in the minimum's row into the priority queue
        // Finally, we stop when k==0...the last minimum we get at that instance is the kth smallest.
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> mat[a[0]][a[1]] - mat[b[0]][b[1]]);
                                                                                     
        for(int i = 0; i<m; i++)
            pq.offer(new int[]{i,0});
        int tmp[] = {0,0};
        while(k>0)
        {
            tmp = pq.poll();
            if(tmp[1]+1<n)
                pq.offer(new int[]{tmp[0], tmp[1]+1});
            k--;
        }
        return mat[tmp[0]][tmp[1]];
    }
}

