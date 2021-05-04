class Solution:
    # REFER:- https://youtu.be/EgI5nU9etnU
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        
        preMap = {i:[] for i in range(numCourses)}
        
        for crs, pre in prereq:
            preMap[crs].append(pre)
            
        vis = set()
        def dfs(crs):
            if crs in vis:
                return False
            if len(preMap[crs])==0:
                return True
            
            vis.add(crs)
            for j in preMap[crs]:
                if dfs(j)==False: return False
            vis.remove(crs)
            preMap[crs] = []
            return True
        
        for i in range(numCourses):
            if not dfs(i): return False
        return True