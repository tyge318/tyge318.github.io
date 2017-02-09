Just simple math.  
Find the number first and then find which digit in the number.  
count of 1 digit numbers = $$9 \times 1 = 9$$  
count of 2 digit numbers = $$(99 - 9) \times 2 = 180 $$  
count of 3 digit numbers = $$(999 - 99) \times 3 = 2700 $$  
count of 4 digit numbers = $$(9999 - 999) \times 4 = 36000 $$  
...  
count of n digit numbers = $$(9 \times n \times 10^{n-1})$$  
Use variable `digitCount` to trace the number range and figure out how many digits the target number has.  
Time Complexity: $$O(\log n)$$. 