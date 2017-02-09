public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetList = bsearchList(matrix, 0, matrix.length-1, target);
        //System.out.println(targetList);
        if( targetList == -1)
            return false;
        return bsearch(matrix[targetList], 0, matrix[0].length-1, target);
    }
    public boolean bsearch(int[] list, int begin, int end, int target) {
        if( begin == end )
            return (list[begin] == target);
        int mid = (begin+end)/2;
        if( list[mid] == target )
            return true;
        else if( list[mid] > target )
            return bsearch(list, begin, Math.max(begin, mid-1), target);
        else
            return bsearch(list, Math.min(mid+1, end), end, target);
    }
    public int bsearchList(int[][] matrix, int begin, int end, int target) {
        if( begin == end) {
            if( listMatch(matrix, begin, target) == 0 )
                return begin;
            else
                return -1;
        }
        int mid = (begin + end)/2;
        int tell = listMatch(matrix, mid, target);
        switch(tell) {
            case 0:
                return mid;
            case -1:
                return bsearchList(matrix, Math.min(mid+1, end), end, target);
            case 1:
                return bsearchList(matrix, begin, Math.max(begin, mid-1), target);
        }
        return -1;
    }
    public int listMatch(int[][] matrix, int id, int target) {
        int col = matrix[0].length;
        if(matrix[id][0] <= target && matrix[id][col-1]>=target)
            return 0;
        else if(matrix[id][col-1] < target)
            return -1;
        else if(matrix[id][0] > target)
            return 1;
        return 2;
    }
}