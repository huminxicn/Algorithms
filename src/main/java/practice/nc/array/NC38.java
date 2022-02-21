package practice.nc.array;

import java.util.ArrayList;

/**
 * 螺旋矩阵。
 * https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31?tpId=117&tqId=37738&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high&difficulty=&judgeStatus=&tags=/question-ranking
 * <p>
 * 给定一个 m x n 大小的矩阵（m 行，n 列），按螺旋的顺序返回矩阵中的所有元素。
 * <p>
 * 输入：
 * [[1,2,3],[4,5,6],[7,8,9]]
 * 返回值：
 * [1,2,3,6,9,8,7,4,5]
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/21 18:41
 */
public class NC38 {
    /**
     * 1.打印矩阵第一行
     * 2.移除矩阵第一行并形成一个新的矩阵
     * 3.向左旋转矩阵并形成一个新的矩阵
     * 4.回到步骤 1
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        //旋转
        spiral(matrix, result);
        return result;
    }

    public void spiral(int[][] matrix, ArrayList<Integer> list) {
        //将矩阵的第一行添加到 list 中。
        for (int i = 0; i < matrix[0].length; i++) {
            list.add(matrix[0][i]);
        }
        //如果矩阵只剩一行就返回。这是递归结束条件。
        if (matrix.length == 1) {
            return;
        }
        //new 一个新的矩阵，去掉原来矩阵的第一行。
        int[][] newMatrix = new int[matrix.length - 1][matrix[0].length];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i - 1][j] = matrix[i][j];
            }
        }
        //将矩阵逆时针旋转 90 度。
        newMatrix = turnLeft(newMatrix);
        //递归调用。
        spiral(newMatrix, list);
    }

    /**
     * 向左旋转 90 度。
     * <p>
     * https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
     */
    public int[][] turnLeft(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[arr[0].length - 1 - j][i] = arr[i][j];
            }
        }
        return result;
    }
}
