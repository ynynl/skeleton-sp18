import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {

    StudentArrayDeque student = new StudentArrayDeque();
    ArrayDequeSolution solution = new ArrayDequeSolution();

    int random_len = 10;

    int[] random = StdRandom.permutation(random_len);

    @Test
    public void testArrayDequeGold() {
            for (int r: random) {
                if (StdRandom.bernoulli()) {
                    student.addFirst(r);
                    solution.addFirst(r);
                }
                else {
                    student.addLast(r);
                    student.addLast(r);
                }

            }


//            System.out.println(random);
            for (int i = 0; i < random_len; i+=1) {
                assertEquals(student.removeFirst(),solution.removeFirst());
            }
    }

}
