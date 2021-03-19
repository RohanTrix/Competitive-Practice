package Leetcode;
import java.util.*;
public class Keys_and_Rooms {
    HashSet<Integer> hs = new HashSet<Integer>();
    public void DFS(List<List<Integer>> rooms, int currRoom)
    {
        //Simple DFS....At the end..check if no. of visited rooms == no. of rooms
        if(hs.contains(currRoom)) return;
        hs.add(currRoom);
        for( int i = 0;i<rooms.get(currRoom).size();++i)
        {
            DFS(rooms, rooms.get(currRoom).get(i));
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        DFS(rooms, 0);
        return hs.size()==rooms.size();
    }
}
