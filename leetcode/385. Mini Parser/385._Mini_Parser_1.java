/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> st = new Stack<NestedInteger>();
        
        NestedInteger current = null;
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == '[' ) {
                if( current != null)
                    st.push(current);
                current = new NestedInteger();
            } 
            if( (cc >= '0' && cc <= '9') || cc == '-' ) {
                temp.append(cc);
                continue;
            }
            if( cc == ',') {
                if( temp.length() != 0) {
                    NestedInteger inner = new NestedInteger(Integer.parseInt(temp.toString()));
                    current.add(inner);
                    temp.delete(0, temp.length());
                }
                continue;
            }
            if( cc == ']') {
                if( temp.length() != 0) {
                    NestedInteger inner = new NestedInteger(Integer.parseInt(temp.toString()));
                    current.add(inner);
                    temp.delete(0, temp.length());
                }
                NestedInteger hold = current;
                if( st.empty() )    return current;
                current = st.pop();
                //System.out.println("(before add) current = " + printList(current.getList()) );
                current.add(hold);
                //System.out.println("(after add) current = " + printList(current.getList()) );
            }
        }
        if( temp.length() != 0)
            return (new NestedInteger(Integer.parseInt(temp.toString())) );
        return (new NestedInteger());
    }
    public String printList(List<NestedInteger> list) {
        StringBuilder ans = new StringBuilder();
        ans.append('[');
        for(NestedInteger ni: list) {
            if( ans.length() != 1)  
                ans.append(',');
            if( ni.getInteger() == null ) {
                ans.append(printList(ni.getList()));
            }
            else
                ans.append(ni.getInteger());
        }
        ans.append(']');
        return ans.toString();
    }
}