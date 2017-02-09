class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> trace;
        while( n != 1) {
            trace.insert(n);
            n = compute(n);
            if( trace.find(n) != trace.end())   return false;
        }
        return true;
    }
    int compute(int n) {
        int ans = 0;
        while( n > 0) {
            int digit = n % 10;
            ans += digit*digit;
            n /= 10;
        }
        return ans;
    }
};