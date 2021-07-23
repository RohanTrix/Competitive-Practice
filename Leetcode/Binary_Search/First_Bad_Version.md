/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
```java
      public class First_Bad_Version extends VersionControl {
        public int firstBadVersion(int n) {
            
            int l = 1, r = n;
            int ans = 1;
            while(l<=r)
            {
                int mid  = l+(r-l)/2;
                if(isBadVersion(mid))
                
                {
                    ans = mid;
                    r = mid-1;
                }
                else
                    l = mid+1;
                
            }
            return ans;
            
        }
    }

```