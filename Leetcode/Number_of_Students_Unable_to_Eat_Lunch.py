class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        int cnt=0, n = students.length;
        boolean f=true;
        for(int i=0;i<n;i++)
        {
            int currFood = sandwiches[i];
            for(int j=0;j<n;j++)
            {
                f=true;
                if(students[j]==currFood)
                {
                    students[j] = -1;
                    f=false;
                    break;
                }
            }
            if(f)
            {
                for(int j=0;j<n;j++)
                    if(students[j]!=-1) cnt+=1;
                return cnt;
            }
        }
        return 0;
    }
}