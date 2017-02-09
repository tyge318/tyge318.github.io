class Solution {
public:
    string addStrings(string num1, string num2) {
        if( num1.length() < num2.length())  return addStrings(num2, num1);
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        for(; i>=0 && (carry || j >= 0); i--, j--, carry /= 10)
            num1[i] = (carry += num1[i] - '0' + (j >= 0 ? num2[j] - '0' : 0)) % 10 + '0';
        return (carry? "1" : "") + num1;
    }
};