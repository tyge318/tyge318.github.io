public class Solution {
    public String validIPAddress(String IP) {
        if( IP.contains("-") )  return "Neither";
        if( isIPv4(IP) )
            return "IPv4";
        else if( isIPv6(IP) )
            return "IPv6";
        else
            return "Neither";
    }
    public boolean isIPv4(String IP) {
        if( IP.isEmpty() || IP.charAt(IP.length()-1) == '.' )   return false;
        String[] parts = IP.split("\\.");
        if( parts.length != 4)  return false;
        for(String s: parts) {
            if( s.length() > 1 && s.charAt(0) == '0')   return false;
            try {
                int temp = Integer.parseInt(s, 10);
                if( temp < 0 || temp > 255) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    public boolean isIPv6(String IP) {
        if( IP.isEmpty() || IP.charAt(IP.length()-1) == ':' )   return false;
        String[] parts = IP.split(":");
        if( parts.length != 8)  return false;
        for(String s: parts) {
            if( s.length() == 0 || s.length() > 4)  return false;
            s = s.toLowerCase();
            try {
                int temp = Integer.parseInt(s, 16);
                if( temp < 0 || temp > 0xffff)  return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}