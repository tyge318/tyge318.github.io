class Solution {
public:
    bool repeatedSubstringPattern(string str) {
        int n = str.length();
        if( n < 1)  return false;
        for(int i=1; i<=n/2; i++) {
            if( n%i != 0)   continue;
            string ss = shiftByK(str, i);
            if( str == ss)  return true;
        }
        return false;
    }
    string shiftByK(string& str, int k) {
        return str.substr(k)+str.substr(0, k);
    }
};