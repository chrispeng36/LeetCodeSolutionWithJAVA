package WeekendContests;

/**
 * @author ChrisPeng
 * @date 2022/3/14 19:44
 */
public class demo01 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        byte[] arr = solution1.parseHexStr2Byte("1111");
//        System.out.println(arr.length);
        for (byte b : arr) {
            System.out.println(b);
        }
    }
}

class Solution1{
//    public int HextoBinaryCount(String hexStr){
//
//    }
    public static byte[] parseHexStr2Byte(String hexStr){
        if (hexStr.length() < 1)
            return null;
        byte[] res = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1),16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1,i * 2 + 2),16);
            res[i] = (byte) (high * 16 + low);
        }
        return res;
    }
}