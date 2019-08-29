package com.qi.关于数组;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 数组中出现次数超过一半的数字 {

    //出现次数超过一半的数字比其他数字出现的次数加起来的和还要多
    //战地攻防的思想:
    // 1. 首先让数字的第一个元素当作士兵, 数量为1
    // 2.当接下来的数字和他一样就++,否则同归于尽 --
    // 3.当前没有士兵,就让当前下标处作为士兵,继续1,2步,最后剩下的就是最多的士兵
    // 4.最后还需判断一下这个最多的士兵是否多于数组的一半
    public static int MoreThanHalfNum_Solution_02(int [] array) {
        int temp = array[0];
        int count = 1;
        for(int i=1;i<array.length;i++){
            if(count == 0){
                temp = array[i];
                count = 1;
            }else if(temp == array[i]){
                count++;
            }else {
                count--;
            }
        }

        if(count != 0){
            int times = 0;
            for(int i=0;i<array.length;i++){
                if(array[i] == temp){
                    times++;
                }
            }

            if(times*2 >array.length){
                return temp;
            }
        }
        return 0;
    }


    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else {
                map.put(array[i], 1);
            }
        }

        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> s : set){
            if(s.getValue() > array.length/2){
                return s.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,2,2,2,5,4,2};
        int result = MoreThanHalfNum_Solution(arr);
        System.out.println(result);
    }
}
