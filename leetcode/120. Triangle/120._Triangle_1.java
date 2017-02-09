public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> opt = new ArrayList<List<Integer>>();
        opt.add(triangle.get(0));
        for(int i=1; i<triangle.size(); i++) {
            List<Integer> rowOpt = new ArrayList<Integer>();
            List<Integer> prevRow = opt.get(opt.size()-1);
            for(int col=0; col<prevRow.size(); col++) {
                if(col == 0) 
                    rowOpt.add(prevRow.get(col)+triangle.get(i).get(col));
                else
                    rowOpt.set(rowOpt.size()-1, Math.min(rowOpt.get(rowOpt.size()-1), prevRow.get(col)+triangle.get(i).get(col)) );
                rowOpt.add(prevRow.get(col)+triangle.get(i).get(col+1));
            }
            opt.add(rowOpt);
        }
        return Collections.min(opt.get(opt.size()-1));
    }
}