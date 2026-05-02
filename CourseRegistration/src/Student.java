import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}
