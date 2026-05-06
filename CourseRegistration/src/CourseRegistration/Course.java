package CourseRegistration;

import java.io.Serializable;
import Queue.LinkedQueue;
import Queue.Queue;
import Tree.Tree;

public class Course implements Serializable {
    private int CRN;
    private String name;
    private int capacity;
    private Tree<Student> enrolled;
    private Queue<Student> waitingList;

    public Course(int CRN, String name, int capacity) {
        this.CRN = CRN;
        this.name = name;
        this.capacity = capacity;
        this.enrolled = new Tree<Student>();        // empty BST for enrolled students
        this.waitingList = new LinkedQueue<Student>(); // empty queue for waiting list
    }

    public int getCRN() { return CRN; }
    public void setCRN(int CRN) { this.CRN = CRN; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public Tree<Student> getEnrolled() { return enrolled; }
    public Queue<Student> getWaitingList() { return waitingList; }

    public String toString() {
        return "CRN: " + CRN + " | Course: " + name + " | Capacity: " + capacity;
    }
}