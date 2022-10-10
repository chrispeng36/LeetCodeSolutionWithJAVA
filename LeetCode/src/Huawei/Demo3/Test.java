package Huawei.Demo3;

/**
 * @author ChrisPeng
 * @date 9/23/2022 10:51 AM
 */
public class Test {
    public static void main(String[] args) {
        int[] n = {100};
        System.out.println("initial n is: ");
        System.out.println(n[0]);
        test(n);
        System.out.println("changed n is: ");
        System.out.println(n[0]);
    }
    public static void test(int[] n){
         n[0] = n[0] - 1;
    }
}
