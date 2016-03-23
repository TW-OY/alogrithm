import java.util.Scanner;

public class FixedCapacityStack<Item> {
    private Item[] items;
    private int size;

    public FixedCapacityStack(int capacity) {
        items = (Item []) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Item item) {
        items[size] = item;
        size++;
    }

    public Item pop() {
        size--;
        return items[size];
    }

    public static void main(String[] args) {
        FixedCapacityStack <Integer> stringStack = new FixedCapacityStack(100);
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNext("end")) {
            stringStack.push(scanner.nextInt());
        }
        while(!stringStack.isEmpty()) {
            int current = stringStack.pop();
            System.out.println(current);
        }
    }
}
