import java.math.BigInteger;

public class Solution {
    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            //s1 == s2 => return 0
            //s1 > s2 => return 1
            //s1 < s2 => return -1
            BigInteger temp1 = new BigInteger(s1+s2);
            BigInteger temp2 = new BigInteger(s2+s1);
            return temp1.compareTo(temp2);
        }
    }
    public String largestNumber(int[] nums) {
        List<String> data = new ArrayList<String>();
        for(int i=0; i<nums.length; i++)
            data.add(Integer.toString(nums[i]) );
        
        Collections.sort(data, new StringComparator() );
        //System.out.println(data.toString());
        StringBuilder temp = new StringBuilder();
        while( !data.isEmpty() )
            temp.append(data.remove(data.size()-1));
        String ans = temp.toString();
        if( ans.matches("[0]+") )
            return "0";
        return ans;
    }

}