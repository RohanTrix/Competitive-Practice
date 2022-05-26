public class Minimum_Area_Rectangle {
    // REFER : https://leetcode.com/problems/minimum-area-rectangle/discuss/900264/IntuitiveWith-PicturesC%2B%2BJavaExplanation
    public int minAreaRect(int[][] points) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int point[] : points)
            map.computeIfAbsent(point[0], k -> new HashSet<>()).add(point[1]);

        int mini = Integer.MAX_VALUE/2;
        for(int P1[] : points) // P1 = (x1,y1)
            for(int P2[] : points) // P2 = (x2,y2)
            {
                
                if(P1[0]!=P2[0] && P1[1]!=P2[1])
                {

                    if(map.get(P1[0]).contains(P2[1]) && map.get(P2[0]).contains(P1[1]))
                        mini = Math.min(mini, Math.abs(P2[0] - P1[0]) * Math.abs(P2[1] - P1[1]));
                    
                }
                
            }
        return mini==Integer.MAX_VALUE/2?0:mini;
    }
}
