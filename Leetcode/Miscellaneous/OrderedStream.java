import java.util.*;
public class OrderedStream 
{

    static String arr[];
    static int ptr;
    public OrderedStream(int n) {
        
        arr = new String[n+1];
        Arrays.fill(arr,null);
        ptr = 1;
    }
    
    public List<String> insert(int id, String value) {
        
        arr[id] = value;
        ArrayList<String> ar = new ArrayList<>();
        if(ptr==id)
        {
            while(ptr<arr.length && arr[ptr]!=null)
            {
                ar.add(arr[ptr]);
                ptr++;
            }
        }
        return ar;
            
        
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */