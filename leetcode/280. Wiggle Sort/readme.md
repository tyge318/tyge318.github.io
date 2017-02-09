Trick is on **line 5**.  
Variable `temp` is to hold previous element. And `i%2 == 1` tells whether its index is odd or even.  
If `i%2 == 1` is **true**, then current element is on odd position, and it needs to $$\ge$$ previous element.  
Thus, if `temp > nums[i]` is **true** (i.e. violate the condition), then we need to swap. Otherwise it meets the condition.  
Similarly, if `i%2 == 1` is **false**, then current element is on even position, and it needs to $$\lt$$ previous element.  
Thus, if  `temp > nums[i]` is **false** (i.e. current $$\gt$$ previous, violate the condition), then we need to swap. Otherwise it meets the condition.  
Time Complexity: $$O(n)$$