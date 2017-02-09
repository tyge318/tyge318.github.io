The solution I came up with in the first place, though it was accepted, is not clever enough.  
Basically the idea is to use `Stack`, but I spent much code dealing with edge cases.  
The following solution is referenced from [Leetcode Discussion](https://discuss.leetcode.com/topic/55247/9-lines-4ms-java-solution/2), which use array to trace directory level. Very brilliant solution.  
The idea is to **separately** trace path length of different levels. There would never be **level skip** in forward jumps (for example, if we want to reach level 3, we **must** visit level 1 and level 2 first. There's not way to jump from level 1 directly to level 3); backward level skips are handled by seperately tracing different level paths, and forward level skips don't exist so the path we memorized is guaranteed to be the valid one.  

Time Complexity: $$O(n)$$ where $$n$$ is the number of lines in the input string.