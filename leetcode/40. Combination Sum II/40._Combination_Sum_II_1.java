public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> opt = new ArrayList<List<List<Integer>>>();
        for(int i=0; i<=target; i++) {
            //List<List<Integer>> current = new ArrayList<List<Integer>>();
            Set<List<Integer>> current = new HashSet<List<Integer>>();
            for(int j=0; j<candidates.length; j++) {
                if( i<candidates[j] )
                    continue;
                if( i == candidates[j] ) {
                    List<Integer> sub = new ArrayList<Integer>(Arrays.asList(j));
                    current.add(sub);
                }
                else {
                    int diff = i-candidates[j];
                    List<List<Integer>> diffLists = opt.get(diff);
                    for(int k=0; k<diffLists.size(); k++) {
                        List<Integer> sub = new ArrayList<Integer>(diffLists.get(k));
                        if( sub.contains(j))
                            continue;
                        sub.add(j);
                        Collections.sort(sub);
                        current.add(sub);
                    }
                }
            }
            opt.add(new ArrayList<List<Integer>>(current));
        }
        List<List<Integer>> indexList = opt.get(target);
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        for(int i=0; i<indexList.size(); i++) {
            List<Integer> subList = indexList.get(i);
            List<Integer> current = new ArrayList<Integer>();
            for(int j=0; j<subList.size(); j++) {
                current.add(candidates[subList.get(j)]);
            }
            ans.add(current);
        }
        return (new ArrayList<List<Integer>>(ans));
    }
}