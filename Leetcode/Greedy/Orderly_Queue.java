public class Orderly_Queue
{
    // REFER : https://youtu.be/5TNRCLbU7H4
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        } else {
            String min = s;
            for (int i = 0; i < s.length(); i++) {
                s = s.substring(1) + s.charAt(0);
                min = min.compareTo(s) < 0 ? min : s;
            }
            return min;
        }
    }
}