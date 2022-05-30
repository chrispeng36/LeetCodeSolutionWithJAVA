package No468;

/**
 * @author ChrisPeng
 * @date 2022/5/29 0:36
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.validIPAddress("172.16.254.1");
        System.out.println(s);
    }
}

class Solution {
    public String validIPAddress(String queryIP) {
        //判断一个字符串是否为合法的IP地址
        if (queryIP == null) return "Neither";
        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

        String result = "Neither";
        if (queryIP.matches(regexIPv4)) {
            result = "IPv4";
        } else if (queryIP.matches(regexIPv6)) {
            result = "IPv6";
        }
        return result;
    }
}