public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        return search(matrix, 0, m-1, 0, n-1, target);   
    }
    public boolean search(int[][] matrix, int rb, int re, int cb, int ce, int target) {
        if( rb > re || cb > ce)
            return false;
        int rm = (rb+re)/2, cm = (cb+ce)/2;
        if( matrix[rm][cm] == target)
            return true;
        else if( matrix[rm][cm] > target) {
            return (search(matrix, rb, rm-1, cb, cm-1, target) ||   //top-left
                    search(matrix, rb, rm-1, cm, ce, target) ||     //top-right
                    search(matrix, rm, re, cb, cm-1, target) );     //bottom-left
        }
        else {  
            return (search(matrix, rb, rm, cm+1, ce, target) ||     //top-right
                    search(matrix, rm+1, re, cb, cm, target) ||       //bottom-left
                    search(matrix, rm+1, re, cm+1, ce, target) );     //bottom-right
        }
    }
}