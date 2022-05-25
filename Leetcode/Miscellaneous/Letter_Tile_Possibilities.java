public class Letter_Tile_Possibilities
{
    // IDEA : Maintain a bitmask to check which elements are used or not.
    Set<String> set = new HashSet<>();
    public void dfs(String s, int mask, String tiles)
    {
        set.add(s);
        if(mask == (1<<tiles.length()) - 1) return;
        // System.out.println(set);

        for(int i = 0; i<tiles.length(); i++)
        {
            if((mask&(1<<i))==0)
                dfs(s+tiles.charAt(i),mask|(1<<i), tiles);
        }
    }
    public int numTilePossibilities(String tiles) {
        dfs("", 0, tiles);
        return set.size()-1;
    }
}