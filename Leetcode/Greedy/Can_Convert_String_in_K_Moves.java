public class Can_Convert_String_in_K_Moves {
    /*
     *      Nice greedy problem
     *      IDEA : We basically want to check if the max shift for a letter is within our k moves.
     *             If the shift is 0, we do nothing. The major case we need to handle is something like:
     * 
     *                  One conversion from 'a' -> 'c' is needed...and later another conversion of
     *                  'x' -> 'z' is needed. Both of them have a shift of 2, but you can shift twice only
     *                  once(i.e during the second move). So, for the second conversion, we need the next cycle of
     *                  2...which is (2+26) = 28...and then if there is a third conversion with shift =2...we will
     *                  need the next cycle (28+26)..and so on..
     * 
     *            So the approach is to maintain a HashMap which maps the shift (max 26 values as keys) to the
     *            latest cycle of that shift it is at...so if we have already done 2 conversions of shift=2,
     *            the key in the map will be 2 -> (2+26)...and so the third conversion will have actualShift as
     *            (2+26 + 26)...And finally, we need to see the maxShift we needed across all chars...if that is 
     *            within k, then it is possible to convert.
     */
    public boolean canConvertString(String str, String ttr, int k) {
        char s[] = str.toCharArray();
        char t[] = ttr.toCharArray();
        int maxi = 0;
        Map<Integer, Integer> map = new HashMap<>();
        if(s.length !=t.length) return false;
        for(int i = 0; i<s.length; i++)
        {
            int shift = (t[i] - s[i] + 26)%26; // Cylic shift in one line
            int actualShift = shift;
            if(shift == 0) continue;
            if(!map.containsKey(shift))
                map.put(shift, shift);
            else
            {
                actualShift = map.get(shift) + 26;
                map.put(shift, actualShift);
            }
            maxi = Math.max(maxi, actualShift);
        }
        return maxi<=k;
    }
}
