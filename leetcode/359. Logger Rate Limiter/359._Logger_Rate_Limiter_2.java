public class Logger {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean ans;
        if( map.containsKey(message) && timestamp - map.get(message) < 10) {
            ans = false;
        }
        else {
            ans = true;
            map.put(message, timestamp);
        }
        return ans;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */