
```java
/*
Structure of node class is as follows:
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Pair
{
    Integer y, n;
    public Pair(int xx, int yy)
    {
        y = xx;
        n = yy;
    }
}
class Solution {
    public Pair dfs(Node root)
    {
        if(root==null) return new Pair(0,0);
        Pair p1 = dfs(root.left);
        Pair p2 = dfs(root.right);
        Integer with = p1.n + p2.n + 1;
        Integer without = Math.max(p1.y, p1.n) + Math.max(p2.y, p2.n);
        return new Pair(with, without);
    }
    public int LISS(Node node){
        //Write your code here  
        Pair p = dfs(node);
        return Math.max(p.y, p.n);
        
    }
}
```