package practice.zuo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/26 19:53
 */
public class PriorityQueueTest {
    static class Rectangle {
        int length;
        int weight;

        Rectangle(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }
    }

    static Comparator<Rectangle> cRectangle = new Comparator<Rectangle>() {
        public int compare(Rectangle o1, Rectangle o2) {
            if (o1.length != o2.length)
                return o1.length - o2.length;
            else
                return o2.weight - o1.weight;
        }

    };

    public static void main(String[] args) {
        PriorityQueue<Rectangle> queue = new PriorityQueue<>(cRectangle);
        Rectangle r1 = new Rectangle(1, 2);
        Rectangle r2 = new Rectangle(2, 5);
        Rectangle r3 = new Rectangle(2, 4);
        Rectangle r4 = new Rectangle(1, 3);
        queue.add(r1);
        queue.add(r2);
        queue.add(r3);
        queue.add(r4);
        Rectangle rectangle;
        while (!queue.isEmpty()) {
            rectangle = queue.poll();
            System.out.println("length=" + rectangle.length + ", weight=" + rectangle.weight);
        }
    }

}
