package Leetcode.Greedy;
import java.util.*;

class Two_City_Scheduling {
    
    /* 
    BEST EXPLANATION (long but PERFECT):
    
    The cost of sending a flyer to city B is relative to the cost of sending them to city A. 
    If we send them to city B, then we have to send some other flyer to city A 
    because we need N people in both cities. We could generally find the highest 
    costs to B and send those people to A, but if they also have a high cost to A, 
    then we didn't save much. Similarly, if we find the lowest costs to B and send those people to B, 
    then we might not have saved much money over sending them to A - and meanwhile if that action 
    caused us to send someone to A who cost us a lot more, we've lost money overall.
    
    Another way to look at it is that each person costs a certain amount to fly 
    regardless of the city they go to, then they cost an additional premium to fly 
    to one of the cities over the other. If their cost pair is [1000,1001] basically 
    that person costs 1000 no matter what and we are only looking at saving or spending 
    that extra dollar. We could reduce the solution by subtracting the minimum cost from both sides 
    of each pair and then looking at optimizing the differential costs. That person's costs would 
    then be fixed=1000, relative=[0,1]. It produces the same answer, but it seems simpler because 
    now everyone has a 0 (relative) cost for one city and a non-zero cost to the other. The solution 
    at this point would be fairly simple - send the people with the largest differential costs to the 
    city of their 0 relative cost, and then when you get the people with large differences assigned you end 
    up with a lot of people with small differences, you keep doing this, saving less and less each time 
    until you might end up with a bunch of people who all cost extra money to send to one city, 
    but you've already assigned everyone you need to the other city. For example, 
    the cost pairs [10,5], [10,7], [10,8], [5,10] could be made differential and you would get 
    the costs fixed = [5,7,8,5], differentials=[[5,0],[3,0],[2,0],[0,5]] You know it will cost you 
    at least 5+7+8+5 == 25 to send everyone, but how can you save the remaining costs? You obviously 
    send the first person to city B and the last to city A and now you have one more for each city and 
    the remainig differential costs are [3,0],[2,0]. You can't send them both to city B since that would 
    leave the cities improperly staffed, so you have to pick one to send to A and the other to B. 
    Clearly you send the one that costs the least extra to send to A which is the latter of the two.
    
    Subtracting out the fixed costs really makes it 
    rather obvious who to send where, you just sort them in the order from most costly to send to A,
     to most costly to send to B and then send the first half to city B and the second half to city A. 
     It seems odd to have a dual-sort where one value is decreasing while the other is increasing, 
     but since all cost pairs have one zero and one non-zero it is pretty obvious that the sorted 
     order starts with the pairs that have a zero differential cost for B and they are in order of 
     decreasing relative cost to send to A, then that is followed by all of the people who have a 
     zero differential cost to go to A in the order of increasing cost to send them to B. It would 
     look something like this: [10,0],[5,0],[3,0],...[0,2],[0,5],[0,100] It's pretty clear that the 
     first person goes to B and the last one goes to A and choosing the first half of the list to 
     go to B would minimize the relative costs for city B and the latter half would minimize the 
     relative costs to go to A.
    
    But, you don't need to actually extract the fixed costs, 
    you can do this with the original amounts just by looking at the difference between the numbers.
     Creating a bunch of relative costs just gives you a bunch of pairs of numbers were one of them is 0.
      If you subtract the A cost from the B cost, you get a single number that sorts the people by 
      the relative cost to send them to B. You then send the ones with the highest relative B cost 
      to A and vice versa.
    
    Thus the technique here, sort the list first 
    by the B-A cost, then the beginning of the list (smallest values of "relative cost to send to B") 
    are the ones you would rather send to B and the ones at the end you'd rather send to A.
    */
    public int twoCitySchedCost(int[][] costs) {
            
            Arrays.sort(costs, (a,b) -> (a[1] - a[0]) - (b[1] - b[0]));
            int cost = 0;
            for (int i = 0; i < costs.length / 2; i++) {

                // W
                cost += costs[i][1] + costs[costs.length-i-1][0];
            }
            return cost;
        
        }
    }