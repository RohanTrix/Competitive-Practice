/*
    IDEA : The 3rd condition is pretty easy to solve.
           For 3rd condition, we try to fix the character we wanna convert to (only 26 characters). And hence, we need to count
           how many chars in both string have to be changed to convert all to the fixed character chosen.


           For the 1st and 2nd conditions, we will fix a threshold character.

           So, for 1st condition, we want all characters in A to be less than or equal to this threshold character,
           and all characters in B to be strictly higher than this threshold character. For second condition, we just need to
           swap the conditions.
           So if we want all chars to be below a certain char in String A, we just need to convert all the chars that are higher
           than this char in String A. Similarly, if all chars need to be more than this char in string B, then we should count
           chars in B which are <= threshold char.
*/
public class Change_Minimum_Characters_to_Satisfy_One_of_Three_Conditions {
    
    public int minCharacters(String a, String b) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        
        for(char ch : a.toCharArray()) freq1[ch-'a']++;
        for(char ch : b.toCharArray()) freq2[ch-'a']++;
        int cost = Integer.MAX_VALUE;
        //Condition 3
        for(int i = 0; i<26; i++)
            cost = Math.min(cost, a.length()+b.length()-(freq1[i]+freq2[i]));
        
        // Condition 1 and 2
        
        for(int i = 0; i<25; i++)
        {
            int lowCosta = 0, lowCostb = 0, highCosta = 0, highCostb = 0;
            for(int j = i+1; j<26; j++)
            {
                lowCosta+=freq1[j];
                lowCostb+=freq2[j];
            }
            for(int j = i;j>=0; j--)
            {
                highCosta+=freq1[j];
                highCostb+=freq2[j];
            }
            cost = Math.min(cost, lowCosta+highCostb);
            cost = Math.min(cost, highCosta+lowCostb);
        }
        
        return cost;
    }
}
