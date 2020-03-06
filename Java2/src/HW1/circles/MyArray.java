package HW1.circles;

public class MyArray<T> {

    private T[] arr;

    private int len;


    public int getLength() {
        return len;
    }

    public MyArray() {
        this.arr = (T[])new Object[0];
        this.len = 0;
    }


    public MyArray(int len) {
        this.arr = (T[])new Object[len];
        this.len = len;
    }

    public T[] getArray() {
        return arr;
    }

    public void set(int ix, T value) {
        arr[ix] = value;
    }

    public T get(int ix) {
        return arr[ix];
    }


    public void delete() {
        delete(len - 1);
    }

    public void delete(int ix) {
        if(len == 0 || ix < 0 || ix > len) {
            return;
        }

        T[] newArr = (T[])new Object[len - 1];

        for (int i = 0; i < ix; i++) {
            newArr[i] = arr[i];
        }

        for (int i = ix; i < len - 1; i++) {
            newArr[i] = arr[i + 1];
        }

        this.arr = newArr;
        len--;
    }

    public void add(T num) {
        if(len == arr.length) {
            T[] newArr = (T[])new Object[len + 1];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len] = num;
        len++;
    }

    public int find(T num) {
        for (int i = 0; i < len; i++) {
            if(arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            sb.append(arr[i]);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
