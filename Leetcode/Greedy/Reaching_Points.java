public class Reaching_Points
{
    // REFER : https://leetcode.com/problems/reaching-points/discuss/230588/Easy-to-understand-diagram-and-recursive-solution
    // TOUGH MODULO APPLICATION CONCEPT
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx < tx && sy < ty)
        {
            if(tx<ty)
                ty%=tx;
            else
                tx%=ty;
        }
        if(sx == tx)
            return ty>=sy && (ty-sy)%sx == 0;
        if(sy == ty)
            return tx>=sx && (tx-sx)%sy == 0;
        return false;
    }
}