class Solution:

    # X and Y will have log amt of powers uptil bound. So we can brute force each combination in O(log(x)*log(y)). Check discussion for better math explanation
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:

        X, Y, res = [1], [1], set()
        while x>1 and X[-1] <=bound:
            X.append(X[-1]*x)

        while y>1 and Y[-1] <=bound:
            Y.append(Y[-1]*y)
        for i in X:
            for j in Y:
                if i+j<=bound:
                    res.add(i+j)
        return list(res)