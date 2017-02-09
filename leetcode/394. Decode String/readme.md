When it comes to parenthesis, brackets and braces, there's a clear clue to use **stack**.  
Here we need two stacks; one to hold the encoded string to be repeated and the other to hold `k`.  
We will also use a `StringBuilder` structure as a buffer to hold temporary chars before pushing them into stacks since we will process the string char by char.  
To utilize the `matches()` function provided by the String API, when we iterate through each char, we make it as a single char string.  
Current char will be in either on oe the following 3 cases:

1. current char is a digit. Then there are 2 subcases.  
1a. the buffer is empty or it holds other digit. Then it means current char is part of a number so we append it to the buffer.  
1b. otherwise, the buffer should contain some char other than digits or brackets. So before we use the buffer to hold digits, we need to push the temporary string to our string stack. Note that we should always keep the number stack the same size as the string stack. Therefore, if the number stack is empty while the string stack is not then we need to do a **prefix merge**.  
2. current char is a letter (`[a-zA-Z]`). Then we just append current letter into buffer.
3. current letter is the bracket open or bracket close.  
3a. if it's a bracket open, then the buffer must hold some number so we push that number into number stack. Reset the buffer.  
3b. if it's a bracket close, then it's the end of the target string (the string to be repeated). The target string could be in the buffer if it's not empty or at the stack top if the buffer is empty. The number of repeating time will be at the top of the number stack. Do the repeating and **prefix merge**. Reset buffer and continue.  
When we reach the string end, make sure nothing is in the buffer. If there is, then we need to merge it with whatever in the string stack again.   
Done.

Time Complexity: $$O(n)$$. 