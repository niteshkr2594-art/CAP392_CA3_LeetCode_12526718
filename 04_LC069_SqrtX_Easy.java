class Solution {
    public int mySqrt(int x) {
        long i = 1;
        int ans = 0;
        while(i*i <= x){
            ans = (int)i;
            i++;
        }
        return ans;
    }
}


