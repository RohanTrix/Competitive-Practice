package Leetcode;

public class Valid_Square {
    public int calcDist(int p1[], int p2[]) //Calculates Distance
    {
        return ((p1[0]-p2[0])*(p1[0]-p2[0])) + ((p1[1]-p2[1])*(p1[1]-p2[1]));
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)     
    {
        
        int[][] arrays = new int[][] { p1, p2, p3, p4}; //Arrays of points
        Arrays.sort(arrays, (int[] o1, int[] o2) -> (o2[0]==o1[0])?o1[1]-o2[1]:o1[0]-o2[0]); //Sorting array by the first element of each array and finally by 
        
        return (calcDist(arrays[0], arrays[3])==calcDist(arrays[1], arrays[2])) &&
                
                calcDist(arrays[0], arrays[1])==calcDist(arrays[0], arrays[2]) &&
                
                calcDist(arrays[0], arrays[3])!=0;
    }
}
