package week307.No6152;

/**
 * @author ChrisPeng
 * @date 2022/8/21 10:31
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int initial_en = 100, initial_ex = 100;
        int[] en = {1,2,3,4,5,6,7,8,9};
        int[] ex = {1,2,3,1,2,3,1,2,10};
        System.out.println(solution.minNumberOfHours(initial_en, initial_ex, en, ex));
    }
}

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum_energy = 1;
        for (int i = 0; i < energy.length; i++) {
            sum_energy += energy[i];
        }
        int x0 = sum_energy - initialEnergy;
//        System.out.println(x0);
        int temp_experience = initialExperience;
        int x1 = 0;
        for (int i = 0; i < experience.length; i++) {
            if (experience[i] >= temp_experience){
                //如果大于的话就要进行加练
                x1 = Math.max(x1, experience[i] - temp_experience + 1);
            }
            temp_experience += experience[i];
        }
//        System.out.println(x1);
        return x0 + x1 > 0 ? x0 + x1 : 0;
    }
}