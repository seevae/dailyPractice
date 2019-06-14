package io.github.seevae;

/**
 * 题目描述:
 *      找出数组中重复出现的数字
 *
 */
public class Test1 {

    //方法一: 时间,空间复杂度都为O(n)
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null){
            return false;
        }

        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length-1){
                return false;
            }
        }

        int[] newArr = new int[length];
        for(int i=0;i<numbers.length;i++){
            newArr[numbers[i]]++;
        }

        for(int i=0;i<newArr.length;i++){
            if(newArr[i]>1){
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    //时间复杂度为O(n)  空间复杂度为O(1)
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers == null){
            return false;
        }

        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length-1){
                return false;
            }
        }

        for(int i=0;i<length;i++){
            while(i != numbers[i]){

                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] duplication = new int[10];
        int[] arr = {2,3,1,0,2,5,3};
        boolean b = duplicate2(arr,arr.length,duplication);
    }
}
