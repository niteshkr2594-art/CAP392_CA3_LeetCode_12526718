class Solution {
    public int reverse(int x){
        int rev = 0;
        while(x != 0) {
            int digit = x % 10;
            x = x / 10;
            int oldRev = rev;
            rev = rev * 10 + digit;

            if((rev - digit) / 10 != oldRev){
                return 0;
            }
        }
        return rev;
    }
}
