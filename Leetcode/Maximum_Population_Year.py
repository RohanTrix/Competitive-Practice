class Maximum_Population_Year:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        d = {}
        for i in range(len(logs)):
            for y in range(logs[i][0], logs[i][1]):
                if y not in d:
                    d[y] = 1
                else:
                    d[y]+=1
        maxi = -float(inf)
        ans = 0
        for i in sorted(d.keys()):
            if d[i]>maxi:
                ans = i
                maxi = d[i]
        return ans