

import java.util.Arrays;

public class ArrayIntegerSequence implements IntegerSequence {
    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayIntegerSequence() {
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void resize() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public void addFirst(int value) {
        if (size == data.length) {
            resize();
        }
        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = value;
        size++;
    }

    @Override
    public void addLast(int value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }

    @Override
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty sequence.");
        }
        int removedValue = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removedValue;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return data[index];
    }

    @Override
    public void printSequence() {
        if (isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + (i == size - 1 ? "" : " "));
        }
        System.out.println();
    }
}