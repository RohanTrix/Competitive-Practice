/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Populating_Next_Right_Pointers_in_Each_Node_II {
    public Node connect(Node root) {
         ArrayList<ArrayList<Node>> res = new ArrayList<ArrayList<Node>>();
    if (root == null)
    return root;
    // Initialization
    Queue<Node> q = new LinkedList<Node>();
    q.offer(root);
    q.offer(null);
    ArrayList<Node> curr = new ArrayList<Node>();
    while (!q.isEmpty()) {
    Node tmp = q.poll();
    if (tmp != null) {
    curr.add(tmp);
    if (tmp.left != null)
    q.offer(tmp.left);
    if (tmp.right != null)
    q.offer(tmp.right);
    } else {
    ArrayList<Node> c_curr = new ArrayList<Node>(curr);
    res.add(c_curr);
    curr.clear(); // Java will clear the reference, so have to new an new ArrayList.
    // completion of a level;
    if (!q.isEmpty())
    q.offer(null);
    }
    }
    for(ArrayList<Node> al : res)
    {
        for(Node n: al)
            n.next = null;
    }
    for(ArrayList<Node> al : res)
    {
        boolean first=true;
        for(int i=1;i<al.size();i++)
            
            al.get(i-1).next = al.get(i);
    }
        return root;
    }
}