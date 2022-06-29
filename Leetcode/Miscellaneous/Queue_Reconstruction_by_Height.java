public class Queue_Reconstruction_by_Height
{
    // REFER : https://youtu.be/40H5vRK_H2E
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> b[0]==a[0]?a[1]-b[1]:b[0]-a[0]);
        
        for(int i = 1; i<people.length; i++)
        {
            int h = people[i][0], k = people[i][1];
            for(int j = i-1;j>=k;j--)
                people[j+1] = people[j].clone();
            people[k][0] = h;
            people[k][1] = k;
        }
        return people;
    }
}