package Leetcode.Miscellaneous;
import java.util.*;

class Pair
{
    int x,y;
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
    public String toString()
    {
        return x+" "+y;
    }
}
class Nearest_Exit_from_Entrance_in_Maze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int dist[][] = new int[maze.length][maze[0].length];
        
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        q.offer(new Pair(entrance[0], entrance[1]));
        
        maze[entrance[0]][entrance[1]]  ='+';
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1,0,0};
        
        dist[entrance[0]][entrance[1]] = 0;
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            //System.out.println("CURR: "+p.x+" "+p.y);
            if(!(p.x==entrance[0] && p.y==entrance[1]))
            {
            if(p.x==0 || p.x==(maze.length-1) || p.y ==0 || p.y==(maze[0].length-1)) return dist[p.x][p.y];
            }
            
            for(int i = 0; i<4; i++)
            {
                
                if( (p.x+dr[i])<0 || (p.x+dr[i])>(maze.length-1) || (p.y+dc[i])<0 || (p.y+dc[i])>(maze[0].length-1) || maze[p.x+dr[i]][p.y+dc[i]]=='+')continue;
                //System.out.println(nr+" "+nc);
                maze[p.x+dr[i]][p.y+dc[i]]='+';
                dist[p.x+dr[i]][p.y+dc[i]] = dist[p.x][p.y] + 1;
                q.offer(new Pair(p.x+dr[i], p.y+dc[i]));
                //System.out.println(q);
            }
            
        }
        
        return -1;
    }
}