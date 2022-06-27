package chinatel.PRO1.PRO2;

import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 2022/6/5 19:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int speed = scanner.nextInt();
        int limitedSpeed = scanner.nextInt();
        int over = speed - limitedSpeed;
        if (over < 0)
            System.out.println("OK");
        else {
            int overPercent = over * 100 / limitedSpeed;
            if (overPercent < 10)
                System.out.println("OK");
            else if (overPercent < 50)
                System.out.println("Exceed " + overPercent + "%. Ticket 200");
            else
                System.out.println("Exceed "+overPercent + "%. License Revoked");
        }
    }
}
