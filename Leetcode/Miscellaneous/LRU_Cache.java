public class LRU_Cache
{
    // LOGIC : https://youtu.be/xDEuM5qa0zg
    static class Node
    {
        int key, val;
        Node next, prev;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
            next = prev = null;
        }
        public String toString()
        {
            return "("+key+","+val+")";
        }
    }
    int cap;
    Map<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        cap = capacity;
    }
    public void putLatestNode(Node curr)
    {
        Node nextToHead = head.next;
        curr.prev = head;
        curr.next = nextToHead;
        head.next = curr;
        nextToHead.prev = curr;
    }
    public Node removeNode(int key)
    {
        Node curr = map.get(key);
        Node left = curr.prev;
        Node right = curr.next;
        left.next = right;
        right.prev = left;
        return curr;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        Node curr = removeNode(key);
        putLatestNode(curr);
        // System.out.println(map);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node curr = removeNode(key);
            putLatestNode(curr);
            curr.val = value;
        }
        else
        {
            
            if(map.size()==cap)
            {
                Node lastNode = tail.prev;
                Node beforeLast = lastNode.prev;
                beforeLast.next = tail;
                tail.prev = beforeLast;
                map.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            putLatestNode(newNode);
        }
        
    }
}