import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();

    }
}

class DynamicArray<T> {
    private T[] array = (T[]) new Object[10];

    public void add(T el) {
        if (array[array.length - 1] != null) {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = el;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = el;
                    i = array.length;
                }

            }
        }
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array = Arrays.copyOf(array, array.length - 1);
    }

    public T get(int index) {
        return array[index];
    }

}
