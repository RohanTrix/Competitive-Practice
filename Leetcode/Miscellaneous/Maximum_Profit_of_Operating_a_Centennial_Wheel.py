class Solution:
    # REFER : https://youtu.be/5QGk9NGmiNI (Alex Wice Interview Weekly)
    def minOperationsMaxProfit(self, customers: List[int], boardingCost: int, runningCost: int) -> int:
        cust = currProf = maxProf = 0
        rot = -1
        i = 0
        while cust or i<len(customers):
            if i<len(customers):
                cust+=customers[i]
            i+=1
            
            new_cust = min(4, cust)
            currProf += new_cust*boardingCost - runningCost
            cust-=new_cust
            if currProf > maxProf:
                rot = i
                maxProf = currProf
        return -1 if maxProf<0 else rot