class Solution {
public:
    string toHex(int num) {
        if( num == 0)   return "0";
        string ans = "";
        while( num != 0) {
            int temp = num & 0xf;
            ans += (temp >= 10 ? temp - 10 + 'a': temp + '0');
            num = (int)((unsigned)num >> 4);
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};