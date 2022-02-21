package algorithms.search;

/**
 * 简单的二分查找。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/08/11 10:57
 */
public class BinarySearchSimple {

    public static int bSearch2(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找。
     *
     * @param arr   有序数组
     * @param value 待查找的值
     * @return
     */
    public static int bSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int searchCount = 0;
        while (low <= high) {
            searchCount++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                System.out.println("searchCount= " + searchCount);
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        System.out.println("searchCount= " + searchCount);
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{};
        System.out.println(bSearch(a, 4));
        System.out.println(bSearch(a, 10));
        System.out.println(bSearch(b, 10));
        System.out.println(bSearchRecurse(a, 4));
        System.out.println(bSearchRecurse(a, 10));
    }

    /**
     * 递归方式实现二分查找。
     *
     * @param arr
     * @param value
     * @return
     */
    public static int bSearchRecurse(int[] arr, int value) {
        return bSearchRecurse(arr, 0, arr.length - 1, value);
    }

    private static int bSearchRecurse(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bSearchRecurse(arr, mid + 1, high, value);
        } else {
            return bSearchRecurse(arr, mid, high - 1, value);
        }
    }
}
