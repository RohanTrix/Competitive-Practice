/*
    IDEA :
    MAIN TRICK : When two ants collide and turn around, equivalently we can model the situation as 
    if they had just walked through each other.

    Then, the last ant walking to the right that falls off the plank 
    is simply the the one on the left-most plank, and similarly for ants walking to the left...it
    is on the right-most plank.

    We basically want the distance between left-most -> rightEnd....and right-most -> leftEnd
    and we want the max of these as our answer
*/
public class Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int t1 = 0; // Time the last ant going left falls
        for(int num : left) t1 = Math.max(t1, num);
        int t2 = Integer.MAX_VALUE/2; 
        for(int num : right) t2 = Math.min(t2, num);
        t2 = n-t2; // Time the last ant going right falls
        return Math.max(t1, t2);
    }
}
