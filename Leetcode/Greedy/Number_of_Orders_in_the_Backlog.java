package Leetcode.Greedy;

/*
    Solved in One go :)
    
    IDEA : The problem description and explanation itself hints us to keep track of the curr largest
            buy and smallest sell prices. So the Idea of a heap comes in. But moreover, since the question
            has been divided into 2 cases..when a buy order comes vs when a sell order comes...

            So for buy order, we need to keep track of smallest sell orders that can be removed.  
            For sell order, we need to keep track of largest buy orders that can be removed.

            Hence this tells us we need to maintain 2 heaps...A max heap for buy orders and a min heap
            for sell orders.

            Now we kind of use the PQ and do as directed in the question which is
            that when a  buy order comes we want to continuously remove the smallest sell orders
            till it is possible(conditions for that is discusse in code). And likewise for sell order

            There is one little think to note here....if we store each order in these PQs...then we will
            we be doing a lot of computations in adding and removing that we could TLE.

            Instead, the question itself sends the data as batches of orders...And so we put batches of 
            orders in the queue and use math to greedily remove a lot of them at once. 
            At last, batches remaining in the backlog have to be accumulated as orders with modulus.
            More detailed explanation in code
*/


public class Number_of_Orders_in_the_Backlog {
    int mod = (int)1e9+7;
    public int getNumberOfBacklogOrders(int[][] orders) {
        // Always rememeber, we are working on batches at once, not orders
        PriorityQueue<pair> buypq = new PriorityQueue<>(Collections.reverseOrder()); // Max PQ for buy batches
        PriorityQueue<pair> sellpq = new PriorityQueue<>(); // Min PQ for sell batches

        for(int batch[] : orders) // We traverse on each batch
        {
            if(batch[2] == 0) // If batch is a buy batch
            {
                if(sellpq.isEmpty()) // If No sell items in sell backlog, then we add batch to buypq and continue;
                    buypq.add(new pair(batch[0], batch[1]));
                else // Else if there are items in Sell backlog
                {
                    pair currbuy = new pair(batch[0],  batch[1]); // Curr buy batch

                    // We want to repeatly remove from sellpq
                    // We want to remove amt from currbuy and top candidate of sellpq
                    while(currbuy.amt>0 && !sellpq.isEmpty() && currbuy.price>=sellpq.peek().price)
                    {
                        pair topsell = sellpq.poll();
                        long remAmt = Math.min(topsell.amt, currbuy.amt); // Max amt that can be removed from both
                        topsell.amt-=remAmt; currbuy.amt-=remAmt;
                        if(topsell.amt!=0) // Add to sellpq again if all the amt from a batch could not be removed
                            sellpq.add(topsell);
                    }
                    if(currbuy.amt>0) // If the curr buy batch's amt is still remaining, add it to PQ
                        buypq.add(currbuy);
                }
            }
            else // Exactly similar logic applied, but for sell order
            {
                if(buypq.isEmpty())
                    sellpq.add(new pair(batch[0], batch[1]));
                else
                {
                    pair currsell = new pair(batch[0],  batch[1]);
                    while(currsell.amt>0 && !buypq.isEmpty() && currsell.price<=buypq.peek().price)
                    {
                        pair topbuy = buypq.poll();
                        long remAmt = Math.min(topbuy.amt, currsell.amt);
                        topbuy.amt-=remAmt; currsell.amt-=remAmt;
                        if(topbuy.amt!=0)
                            buypq.add(topbuy);
                    }
                    if(currsell.amt>0)
                        sellpq.add(currsell);
                }
            }
        }
        // Remove all batches from both PQs and accumulate their orders under modulo
        long sum = 0;
        while(!buypq.isEmpty())
        {
            sum+=buypq.poll().amt;
            sum%=mod;
        }
        while(!sellpq.isEmpty())
        {
            sum+=sellpq.poll().amt;
            sum%=mod;
        }
        return (int)sum;
        
    }
    static class pair implements Comparable<pair>
    {
        long price, amt;
        public pair(int p, int a)
        {
            amt = a;
            price = p;
        }
        public int compareTo(pair o)
        {
            return Long.compare(this.price, o.price);
        }
    }
}
