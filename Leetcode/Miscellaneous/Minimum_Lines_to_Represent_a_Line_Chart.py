class Solution:
    def minimumLines(self, stocks: List[List[int]]) -> int:
        stocks.sort()
        n = len(stocks)
        if(len(stocks) == 1): return 0
        cnt = 1
        numer = stocks[1][1] - stocks[0][1]
        denom = stocks[1][0] - stocks[0][0]
        for i in range(1,n):
            curr_numer = stocks[i][1] - stocks[i-1][1]
            curr_denom = stocks[i][0] - stocks[i-1][0]
            if( curr_numer*denom == numer*curr_denom):
                continue
            cnt+=1
            numer = curr_numer
            denom = curr_denom
        return cnt