// We keep a pointer to the encoding array
public class RLE_Iterator {
    int p, encoding[];
    public RLEIterator(int[] encoding) {
        p = 0;
        this.encoding = encoding;
    }
    
    public int next(int n) {
        while(p<encoding.length && n>encoding[p])
        {
            n-=encoding[p];
            p+=2;
        }
        if(p == encoding.length) return -1;
        int val = encoding[p+1];
        encoding[p] = encoding[p] - n;
        if(encoding[p] == 0) p+=2;
        return val;
    }
}
