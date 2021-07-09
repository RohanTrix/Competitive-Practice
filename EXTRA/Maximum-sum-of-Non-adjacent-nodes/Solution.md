

```java

/*class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

/* 
It is clear from the question, that we have two answers at every node.
One answer is the max sum we can achieve without using the value of the current node and the other answer is with using it. And we need to send back both the answers so that the best decision can be taken by the parent node of the current node. 

*/



class GFG
{
    //We create a pair class to store the answers for both the cases.
    static class Pair
    {
        int without;
        int with;
        Pair(int with, int without)
        {
            this.with = with; // Stores answer WITH the current node
            this.without = without; // Stores answer WITHOUT current
        }
    }
    public static Pair dfs(Node root)
    {
        //If current node is null, we get 0 in both the cases.
        if(root==null)
            return new Pair(0,0); 

        // Gets the max sum of nodes with and without the node left
        Pair l = dfs(root.left); 

        // Gets max sum of nodes with and witrh
        Pair r = dfs(root.right);
        
        // MAX sum when curr node is taken is calculated from max of:
        //          1) Best sum of nodes of left subtree without the left child
        //          2) Best sum of nodes of right subtree without the right child
        //          3) Sum of the above 2
        int withSubAns = Math.max(l.without,
                         Math.max(r.without, 
                                    l.without + r.without));
        
        // MAX sum when curr node is NOT taken is calculated from max of :
        //          1) Best sum of nodes when taking and not taking left child 
        //          2) Best sum of nodes taking and not taking right child 
        int withoutSubAns = Math.max(l.with, l.without) 
                            + Math.max(r.with, r.without);
        

        //Return Pair of (withSubAns + the value of current node,withoutSubAns)
        return new Pair(withSubAns + root.data, withoutSubAns);
        
    }
    
    static int getMaxSum(Node root)
    {
        Pair fin = dfs(root);
        return Math.max(fin.with, fin.without);
    }
}
```