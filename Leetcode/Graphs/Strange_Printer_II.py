class Solution:
    # Alex Wice Interview Weekly #15
    def isPrintable(self, grid: List[List[int]]) -> bool:
        from collections import defaultdict
        m,n = len(grid), len(grid[0])
        boxes = defaultdict(lambda : [61, 61, -1, -1])
        
        for r, row in enumerate(grid):
            for c,v in enumerate(row):
                boxes[v][0] = min(boxes[v][0], r)
                boxes[v][1] = min(boxes[v][1], c)
                boxes[v][2] = max(boxes[v][2], r)
                boxes[v][3] = max(boxes[v][3], c)
                
        graph = {color : set() for color in boxes}
        
        for color, (r1,c1, r2, c2) in boxes.items():   
            for r in range(r1, r2+1):
                for c in range(c1, c2+1):
                    if grid[r][c]!=color:
                        graph[color].add(grid[r][c])
        
        UNVIS, VISITING, EXPLORED = 0,1,2
        state = defaultdict(int)
        for c in graph:
            state[c] = UNVIS
            
        def dfs(node): # True if no cycle found
            if state[node] == VISITING:
                return False
            elif state[node] == EXPLORED:
                return True
            state[node] = VISITING
            res = all(dfs(to) for to in graph[node])
            state[node] = EXPLORED
            return res
        
        return all(dfs(node) for node in graph if state[node] == UNVIS)
                    
            
            
        