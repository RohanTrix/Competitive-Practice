package Leetcode.Miscellaneous;


// IDEA:
//      1) The sum of areas of smaller rectangle should be equal to area of final big rectangle
//      2) The final rectangle has only 4 corners. There 4 belong to some different rectangle, but all the 
//         other corners are shared in pairs(either 2 or 4 corners meet..check discuss section)
public class Perfect_Rectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<pair> set = new HashSet<>();
        int totArea = 0;
        for(int[] r: rectangles)
        {
            pair botleft = new pair(r[0],r[1]);
            pair botright = new pair(r[0], r[3]);
            pair topleft = new pair(r[2], r[1]);
            pair topright = new pair(r[2],r[3]);
            
            totArea+=((r[2]-r[0]) * (r[3]-r[1]));
            
            if(set.contains(botleft))
                set.remove(botleft);
            else
                set.add(botleft);
            
            if(set.contains(botright))
                set.remove(botright);
            else
                set.add(botright);
            
            if(set.contains(topleft))
                set.remove(topleft);
            else
                set.add(topleft);
            
            if(set.contains(topright))
                set.remove(topright);
            else
                set.add(topright);
        }
        
        if(set.size()!=4) return false;
        
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for(pair p : set){
            //pair p = iter.next();
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        }
        
        return totArea == (maxX - minX) * (maxY - minY);
        //return finalArea==totArea;
        
    }
    private class pair
    {
        int x, y;
        public pair(int a, int b)
        {
            x=a;
            y=b;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !(o instanceof pair)) return false;
            pair that = (pair)o;
            return x == that.x && y == that.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
