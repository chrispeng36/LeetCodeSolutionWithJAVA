//package No6017;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//
///**
// * @author ChrisPeng
// * @date 2022/3/6 10:48
// */
//public class Demo {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = {1,4,25,10,25};
//        long l = solution.minimalKSum(nums, 2);
//        System.out.println(l);
//    }
//}
//
//
//class Solution {
//    public long minimalKSum(int[] nums, int k) {
////        long resNum = 0;
////        int i = 1;//用来计数
////        int count = 0;
////        ArrayList<Integer> list = new ArrayList<>();
////        for (int j = 0; j < nums.length; j++) {
////            list.add(nums[j]);
////        }
////        while (i <= nums.length + k){
////            if (! list.contains(i)){
////                //添加
////                resNum += i;
////                count ++;
////                if (count == k){
////                    break;
////                }
////            }
////            i ++;
////        }
////        return resNum;
////        Arrays.sort(nums);//排序
////        int leftNum = nums[0] - 1;//找到直接可以添加的元素的个数
//////        System.out.println(leftNum);
////        int resNum = 0;//返回值
////        if (leftNum >= k){//如果开始的个数就大于要添加的元素
////            for (int i = 1; i <= k; i++) {
////                resNum += i;
////            }
////            return resNum;
////        }else {//否则的话把开始的全部添加了还不够
////            for (int i = 0; i < leftNum; i++) {
////                resNum += i +1;
////            }
////        }
////        int remain = k - leftNum;//还需要添加的元素的个数
//////        System.out.println(remain);
////        int j = 0;//j用来计数
////        while (j < nums.length - 1){
////            //首先判断两个索引之间是否能添加元素
////            if (nums[j + 1] - nums[j] > 1){
////                for (int i = nums[j] + 1; i < nums[j + 1]; i++) {
////                    resNum += i;
////                    remain --;
////                    if (remain == 0)
////                        return resNum;
////                }
////            }
////            j ++;
////        }
////        //出了循环还没有return说明还没有添加完毕
////        int num = nums[nums.length - 1] + 1;
////        while (remain > 0){
////            resNum += num;
////            num ++;
////            remain --;
////        }
////        return resNum;
//        //首先将数组排序并去重
//        //之后依次考虑数组中的每个数,对于第i个数ai,
//        //不超过它的且不出现在原数组中的正整数一共有ai-i-1个
//        //如果这个数不小于k,则说明我们最大只需要取到k+i,就能得到k个
//
//    }
//}