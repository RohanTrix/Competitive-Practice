public class Watering_Plants_II {
    // Simply simulate
    public int minimumRefill(int[] plants, int capA, int capB) {
        int refils = 0;
        int n = plants.length;
        
        int c1 = capA, c2 = capB;
        for(int i = 0; i<n/2; i++)
        {
            
                if(c1>=plants[i])
                    c1-=plants[i];
                else {
                    refils++;
                    c1 = capA - plants[i];
                }
                if(c2>=plants[n-i-1])
                    c2-=plants[n-i-1];
                else 
                {refils++;c2 = capB - plants[n-i-1];}

        }
        if(n%2!=0)
            if(Math.max(c1,c2)<plants[n/2]) refils++;
        return refils;
    }
}
