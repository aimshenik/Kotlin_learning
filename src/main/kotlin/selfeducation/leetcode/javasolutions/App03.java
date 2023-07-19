package selfeducation.leetcode.javasolutions;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class App03 {

//    private static int cnt = 0;

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
        long nanos = System.nanoTime();
        System.out.println(numberOfSteps(1_000_000));
        long nanos2 = System.nanoTime();
        System.out.println("NANOS SPENT :" + (nanos2 - nanos));
    }

    public static int numberOfSteps(int num) {
        int counter = 1;
        for (; num != 1; counter++) {
            num = num % 2 == 0 ? num >> 1 : num >> 1 << 1;
        }
        return counter;

    }

    private static int collapse(int num, Integer counter) {
        counter++;
        if (num == 1) return counter;
        return num % 2 == 0 ? collapse(num / 2, counter) : collapse(num - 1, counter);
    }
}
