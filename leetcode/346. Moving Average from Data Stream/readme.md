Use `Deque` to holde **live** numbers, and we can also use another variable `sum` to memorize accumulated sum in the run, which saves the need of summing up all numbers each time.  
When the queue size is full, remember to poll the oldest number before add new one.  
Time Complexity: $$O(n)$$