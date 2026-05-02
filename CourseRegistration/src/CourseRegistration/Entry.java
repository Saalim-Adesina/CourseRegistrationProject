package CourseRegistration;
import java.io.Serializable;

public class Entry<E> implements Serializable {
    private int key;
    private E data;
    public Entry(int k, E d) {
        key = k;
        data = d;
    }
    public void display() {
        System.out.print(key + ":");
        System.out.println(data);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
