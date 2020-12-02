public class Shortest_Word_Distance {

    /* We can greatly improve on the brute-force approach by keeping two indices i1 and i2
        where we store the most recent locations of word1 and word2.
        Each time we find a new occurrence of one of the words, we do not 
        need to search the entire array for the other word,
        since we already have the index of its most recent occurrence.
     */

    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
    
            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}
