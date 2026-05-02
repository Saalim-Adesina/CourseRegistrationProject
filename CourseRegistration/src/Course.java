import Queue.Queue;
import Tree.Tree;
// TODO
// 1) Implement
import java.io.Serializable;

public class Course implements Serializable {
    private int CRN;
    private String name;
    private int capacity;
    private Tree<Student> enrolled;
    private Queue<Student> waitingList;

    public Course(int crn, String n, int cap, Tree<Student> enrolled, Queue<Student> waitingList){
      this.CRN = crn;
      this.name = n;
      this.capacity = cap;
      this.enrolled = enrolled;
      this.waitingList = waitingList;
    }
    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Tree<Student> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Tree<Student> enrolled) {
        this.enrolled = enrolled;
    }

    public Queue<Student> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(Queue<Student> waitingList) {
        this.waitingList = waitingList;
    }
}
