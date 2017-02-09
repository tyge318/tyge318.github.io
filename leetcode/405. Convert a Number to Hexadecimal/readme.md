No tricks at all. Partition the integer into 4-bit chunks and get each chunk by bitwise and (to 0xf) and unsigned right shift (the `>>>` operator). 
Time Complexity: $$O(n/4) = O(n)$$