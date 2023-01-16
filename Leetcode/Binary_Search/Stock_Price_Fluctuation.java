package Leetcode.Binary_Search;

import java.util.TreeMap;

class StockPrice {
    TreeMap<Integer, Integer> tm; // Maps timestamp -> latest price
    TreeMap<Integer, Integer> prices; // Maps price -> Count of timestamps having this price
    public StockPrice() {
        tm = new TreeMap<>();
        prices = new TreeMap<>();
    }
    
    // We remove the oldPrice from the prices treemap. Note: oldPrice will only get removed as a key if no other timestamp has curr val as oldPrice
    // We update tm with latest price. 
    public void update(int timestamp, int price) {
        Integer oldVal = tm.containsKey(timestamp)?tm.get(timestamp):null;
        tm.put(timestamp, price);
        if(oldVal!=null)
        {
            prices.put(oldVal, prices.get(oldVal)-1);
            if(prices.get(oldVal) == 0)
                prices.remove(oldVal);
        }
        prices.put(price, prices.getOrDefault(price, 0)+1);

    }
    // Value at max time stamp
    public int current() {
        return tm.get(tm.lastKey());
    }
    // Max Key present in prices
    public int maximum() {
        return prices.lastKey();
    }
    // Min Key present in prices
    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */