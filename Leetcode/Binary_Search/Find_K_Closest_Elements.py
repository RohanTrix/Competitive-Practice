class Solution:

    # REFER EXPLANATION : https://youtu.be/t4gPEqlaNjc
    # After above done, REFER : https://leetcode.com/problems/find-k-closest-elements/discuss/106426/JavaC%2B%2BPython-Binary-Search-O(log(N-K)-%2B-K)
    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - k
        
        while(left < right):
            mid = left + (right - left) //2
            
            if x- arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid;
        return arr[left:left+k]