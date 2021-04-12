package leetcode;

/**
 * @author : saisai.yuan
 * @create : 2021/4/12
 * @description : 合并有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode88MergeSortedArray {

    /**
     * 解法一：
     *  双指针，定义 p1, p2,指针分别指向 两数组的 index，初始为 0，
     *  逐个比较，根据取值大小改变 p1,p2的 index 大小，循环直至结束。
     *
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0;
        int p2 = 0;

        int[] sortedArray = new int[m + n];

        while (p1 + p2 < m + n) {
            if (p1 == m) {
                sortedArray[p1 + p2] = nums2[p2];
                p2++;
            } else if (p2 == n) {
                sortedArray[p1 + p2] = nums1[p1];
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                sortedArray[p1 + p2] = nums2[p2];
                p2++;
            } else {
                sortedArray[p1 + p2] = nums1[p1];
                p1++;
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};

        int[] merge = merge(nums1, 3, nums2, 3);

        for (int i : merge) {
            System.out.println(i + " ");
        }
    }
}
