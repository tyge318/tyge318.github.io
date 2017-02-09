public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, ArrayList<Integer>> table = new TreeMap<Integer, ArrayList<Integer>>();
        
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            int subLength = 0;
            ArrayList<Integer> subTemp = new ArrayList<Integer>();
            for(int j=i-1; j>=0; j--) {
                if( nums[i] % nums[j] == 0 ) {
                    int size = table.get(nums[j]).size();
                    if( size > subLength ) {
                        subLength = size;
                        subTemp = table.get(nums[j]);
                    }
                }
            }
            temp.addAll(subTemp);
            Collections.sort(temp);
            table.put(nums[i], temp);
        }
        int maxLength = 0;
        List<Integer> ans = new ArrayList<Integer>();
        Iterator itr = table.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, ArrayList<Integer>> entry = (Map.Entry<Integer,ArrayList<Integer>>) itr.next();
			int currentLength = entry.getValue().size();
			if(currentLength > maxLength) {
			    maxLength = currentLength;
			    ans = entry.getValue();
			}
		}
		return ans;
    }
}