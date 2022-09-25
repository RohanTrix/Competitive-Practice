'''
        IDEA : To group the paths by same content, we need to MAP content to list of paths having that content
               Rest is just string manipulation
'''

class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        from collections import defaultdict
        d = defaultdict(list)
        
        for path in paths:
            pathList = path.split() # Contains [root dir, fileName1(text1), fileName2(text2)....]
            
            for idx, file in enumerate(pathList):
                if idx == 0: # Skip root dir
                    continue
                b1 = file.find('(') # bracket 1
                b2 = file.find(')') # bracket 2
                fileName = file[:b1] # Extracting fileName
                content = file[b1:b2] # Extracting content
                
                d[content].append(pathList[0] + '/' + fileName) # Creating file path and adding to list belonging to content extracted
        
        ans = []
        for v in d.values():
            if len(v)>1: # append only duplicate groups to the answer
                ans.append(v)
        return ans