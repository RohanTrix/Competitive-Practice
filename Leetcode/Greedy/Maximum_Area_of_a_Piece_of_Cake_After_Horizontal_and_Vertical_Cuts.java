/*
    IDEA: The first thing that should come to mind is sorting the cuts, since we want to compare distance b/w adjacent cuts

          To imagine it easily, thing about only one of the type of cuts first, horizontal or vertical. The larger the cuts are at a distance,
          the more they contribute to the area. 
          
          Now, lets say we pick a pair of adjacent horizontal cuts which have some vertical height = hh.
          If we now consider each pair of adjacent vertical cuts one by one, we will see that the height hh is same for all, and so taking
          the largest width should give the best answer for this pair of horizontals cuts. So since the contribution hh is same for all,
          we might as well make hh the largest. And similarly, make the width also the largest. The area of this should be maximum.
*/

public class Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts {
    public int maxArea(int h, int w, int[] horcuts, int[] vercuts) {
        Arrays.sort(horcuts);
        int nh = horcuts.length;
        int height = Math.max(h-horcuts[nh-1], horcuts[0]);
        
        for(int i = 1; i<nh; i++)
            height = Math.max(height, horcuts[i] - horcuts[i-1]);
        
        Arrays.sort(vercuts);
        int nv = vercuts.length;
        int width = Math.max(w-vercuts[nv-1], vercuts[0]);
        
        for(int i = 1; i<nv; i++)
            width = Math.max(width, vercuts[i] - vercuts[i-1]);
        
        int mod = (int)1e9 + 7;
        //System.out.println(height+ " "+width);
        return (int)(1L*height%mod*1L*width%mod)%mod;
    }
}
