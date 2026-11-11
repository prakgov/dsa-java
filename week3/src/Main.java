import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Manually test X3
        TRAI_26_X3 week3Solution = new TRAI_26_X3_prakigov();
        LinkedList<Integer> A1 = new LinkedList<>();
        LinkedList<Integer> B1 = new LinkedList<>();
        A1.add(1);
        A1.add(2);
        A1.add(3);
        B1.add(3);
        B1.add(4);
        System.out.println("Before adding new elements from B1: " + A1); // Expected: [1, 2, 3]
        week3Solution.addNew(A1, B1);
        System.out.println("A1 after adding new elements from B1: " + A1); // Expected: [1, 2, 3, 4]

        LinkedList<String> A2 = new LinkedList<>();
        LinkedList<String> B2 = new LinkedList<>();
        A2.add("apple");
        A2.add("banana");
        B2.add("banana");
        B2.add("cherry");
        System.out.println("Before adding new elements from B2: " + A2); // Expected: [apple, banana]
        week3Solution.addNew(A2, B2);
        System.out.println("A2 after adding new elements from B2: " + A2); // Expected: [apple, banana, cherry]

        // Run complete tests for TRAI_26_X3
        TRAI_26_X3_test.main(args);
    }
}
