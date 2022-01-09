class Solution:
    # REFER: https://youtu.be/nKv2LnC_g6E
    def isRobotBounded(self, instructions: str) -> bool:
        x = y = 0
        dirx, diry = 0,1
        for c in instructions:
            if c=='G':
                x+=dirx
                y+=diry
            elif c=='L':
                dirx,diry = -diry, dirx
            else:
                dirx, diry = diry, -dirx
            
        return (x,y)==(0,0) or (dirx,diry)!=(0,1)
                
            