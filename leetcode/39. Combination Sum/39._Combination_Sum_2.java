public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> opt = new ArrayList<List<List<Integer>>>();
        for(int i=0; i<=target; i++) {
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            for(int j=0; j<candidates.length; j++) {
                if( i<candidates[j] )
                    continue;
                if( i == candidates[j] ) {
                    List<Integer> sub = new ArrayList<Integer>(Arrays.asList(candidates[j]));
                    current.add(sub);
                }
                else {
                    int diff = i-candidates[j];
                    List<List<Integer>> diffLists = opt.get(diff);
                    if( diffLists.size() > 0) {
                        for(int k=0; k<diffLists.size(); k++) {
                            List<Integer> sub = new ArrayList<Integer>(diffLists.get(k));
                            sub.add(candidates[j]);
                            Collections.sort(sub);
                            if( !current.contains(sub))
                                current.add(sub);
                        }
                    }
                }
            }
            opt.add(current);
        }
        return opt.get(target);
    }
}