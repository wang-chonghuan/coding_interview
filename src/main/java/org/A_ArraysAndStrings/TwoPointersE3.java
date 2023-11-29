package org.A_ArraysAndStrings;

/**
 * example 3: given two sorted integer arrays
 * return an array that combines both of them is also sorted
 * 用两个指针分别只想两个数组，比较其值，把小的纸放进数组，同时移动小的指针，大的指针不动
 * 最后大概率一个数组还有剩余，就吧剩余部分追加进结果数组即可
 * 排序数组默认都是从小到大排列的
 */
public class TwoPointersE3 {
    public int[] mergeSortedArr(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1 < arr1.length && i2 < arr2.length) {
            if(arr1[i1] <= arr2[i2]) {
                mergedArr[i] = arr1[i1];
                i1++;
            } else {
                mergedArr[i] = arr2[i2];
                i2++;
            }
            i++;
        }
        while(i1 < arr1.length) {
            mergedArr[i] = arr1[i1];
            i1++;
        }
        while(i2 < arr2.length) {
            mergedArr[i] = arr2[i2];
            i++;
        }
        return mergedArr;
    }
}
