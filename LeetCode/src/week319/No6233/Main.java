package week319.No6233;

/**
 * @author ChrisPeng
 * @date 2022/11/13 10:32
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fah = celsius * 1.80 + 32.00;
        double[] ints = new double[2];
        ints[0] = kelvin;
        ints[1] = fah;
        return ints;
    }
}