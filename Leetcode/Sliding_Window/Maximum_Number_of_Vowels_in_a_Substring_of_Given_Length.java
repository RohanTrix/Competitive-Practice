public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length
{
    public int maxVowels(String s, int k) {
        char str[] = s.toCharArray();
        String vowels = "aeiou";
        int left = 0, maxi = 0;
        int vowelcnt = 0;
        for(int right = 0; right<str.length; right++)
        {
            if(vowels.contains(""+str[right])) vowelcnt++;
            if(right>=k)
            {
                if(vowels.contains(""+str[left++])) vowelcnt--;
            }
            maxi = Math.max(maxi, vowelcnt);
        }
        return maxi;
    }
}