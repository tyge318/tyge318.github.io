This one can be easily solved by the use of `indexOf()` function provided by Java Strings API.  
Simply loop through each char of `s`.  
If current char is not in `t`, then just return false.  
Otherwise, the `indexOf()` function must return the first index that current char shows in `t`; use variable `begin` to hold this value.  
Then we set `t = t.substring(begin+1)` and continue.  
Return true if we can reach the end of `s`.  
Time Complexity: $$O(mn)$$ where $$m$$ is the string length of `s` and $$n$$ is the string length of `t` since each `indexOf()` operation takes $$O(1 \cdot n)$$ time. 