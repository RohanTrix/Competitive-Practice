public class Watering_Plants
{
    public int wateringPlants(int[] plants, int capacity) {
        int bucket = capacity;
        int moves = 0;
        for(int i = 0; i<plants.length; i++)
        {
            moves++;
            bucket-=plants[i];
            if(i+1<plants.length && bucket<plants[i+1])
            {
                bucket = capacity;
                moves+=2*(i+1);
            }
            
        }
        return moves;
    }
}