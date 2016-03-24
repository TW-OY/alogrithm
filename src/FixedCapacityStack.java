import java.util.Iterator;
import java.util.Scanner;

public class FixedCapacityStack<Item> implements Iterable<Item>{
    private Item[] items;
    private int size = 0;

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
        if(isFull()) {
            resize(2 * size);
        }
        items[size] = item;
        size++;
    }

    public boolean isFull() {
        return items.length == size;
    }

    public void resize(int max) {
        Item[] temp = (Item []) new Object[max];
        for(int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public Item pop() {
        if(size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        Item item = items[--size];
        items[size] = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    public class ReverseIterator implements Iterator<Item> {
        private int i = size;
        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return items[--i];
        }

    }


    public static void main(String[] args) {
        FixedCapacityStack <Integer> Stack = new FixedCapacityStack(3);
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNext("end")) {
            Stack.push(scanner.nextInt());
        }
        while(!Stack.isEmpty()) {
            int current = Stack.pop();
            System.out.println(current);
        }
    }
}
