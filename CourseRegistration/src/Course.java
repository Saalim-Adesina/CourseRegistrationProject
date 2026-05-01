import Queue.Queue;
import Tree.Tree;

public class Course {
    private int CRN;
    private String name;
    private int capacity;
    private Tree<Student> enrolled;
    private Queue<Student> waitingList;

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
