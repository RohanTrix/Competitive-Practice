class MyHashMap {

    /** Initialize your data structure here. */
    int arr[];
    public MyHashMap() {
       arr = new int[1000000+1];
        for(int i =0;i<arr.length;i++) arr[i] = -1;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */