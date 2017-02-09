This is not the **Binary Index Tree** solution as tagged in the problem, but it's easier to understand.  
Basically just recompute the accumulative sum for each row and use them to reduce the run time to linear.  
Note that we need to memorize the (original/un-accumulated) matrix in order to do update.  
Time Complexity: <span class="inlinecode">$O(n)$</span> for update and <span class="inlinecode">$O(m)$</span> for sumRegion, where <span class="inlinecode">$m, n$</span> stand for **row size** and **column size**.