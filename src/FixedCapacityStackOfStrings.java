import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class FixedCapacityStackOfStrings {
    private String[] strings;
    private int size;

    public FixedCapacityStackOfStrings(int capacity) {
        strings = new String[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String item) {
        strings[size] = item;
        size++;
    }

    public String pop() {
        size--;
        return strings[size];
    }

//    public static void main(String[] args) {
//        FixedCapacityStackOfStrings stringStack = new FixedCapacityStackOfStrings(100);
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext("end")) {
//            stringStack.push(scanner.nextLine());
//        }
//        while(!stringStack.isEmpty()) {
//            String current = stringStack.pop();
//            System.out.println(current);
//        }
//    }
}
