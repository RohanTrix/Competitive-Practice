public class Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    //  IDEA : Since we have only digits from 1-9...it is feasible to keep a frequency of this
    //         At a leaf, to check if something is palindromable, we should check if the number of odd frequency
    //         is either 0 or atmost 1
    int cnt;
    public void palindromable(int freq[])
    {
        int odd = 0;
        for(int i = 1; i<10; i++)
            if(freq[i]%2!=0)
                odd++;
        if(odd<=1)
            cnt++;
    }
    public void count(TreeNode root, int freq[])
    {
        if(root == null) return;
        freq[root.val]++;
        if(root.left == null && root.right == null)
            palindromable(freq);
        count(root.left,freq);
        count(root.right, freq);
        freq[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int freq[] = new int[10];
        cnt = 0;
        count(root, freq);
        return cnt;
    }
}
