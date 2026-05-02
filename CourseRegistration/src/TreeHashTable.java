import Tree.Tree;
import Queue.LinkedQueue;
import Queue.Queue;

public class TreeHashTable<E> {
    private Entry[] hashArray;
    private Entry defunct;

    public TreeHashTable(int capacity){
        hashArray = new Entry[capacity];
        defunct = new Entry(-1, null);
    }
    public int hashFunc(int key){
        return key % hashArray.length;
    }
    public boolean isFull() {
        for (int i = 0; i < hashArray.length; i++){
            if (hashArray[i] == null || hashArray[i] == defunct) return false;
        }
        return true;
    }
    public void displayTable() {
        for (int i = 0; i < hashArray.length; i++){
            if (hashArray[i] != null) hashArray[i].display();
            else {
                System.out.println("** ");
            }
        }
    }
    public void addCourse(Course course){
        int hashValue = hashFunc(course.getCRN());

        if (!isFull()) {
            while (hashArray[hashValue] != null &&  hashArray[hashValue] != defunct){
                ++hashValue;
                hashValue %= hashArray.length;
            }
            hashArray[hashValue] = new Entry<Course>(course.getCRN(), course);
        }
    }
    public Course search(int k){
        int hashValue = hashFunc(k);
        int start = hashValue;
        boolean checkedAll = false;
        while (hashArray[hashValue] != null && !checkedAll){
            if (hashArray[hashValue].getKey() == k) return (Course) hashArray[hashValue].getData();
            ++hashValue;
            hashValue %= hashArray.length;
            if (hashValue == start) {checkedAll = true;};
        }
        return null;
    }

    public void addStudent(int k, Student s){
    	
    	Course course  = search(k);
    	
    	if (course == null) {
    		
    		throw new IllegalArgumentException("No course found with CRN: " + k);
    		
    	}
    	else {
    		
    		if (course.getEnrolled().count() == course.getCapacity()) {
    			
    			course.getWaitingList().enqueue(s);
    			
    		}
    		else {
    			
    			course.getEnrolled().insert(s.getId(), s);
    			
    		}
    	}

    }
    
    public void dropStudent(int c, int s) {
    	
    	Course course  = search(c);
    	
    	if (course == null) {
    		
    		throw new IllegalArgumentException("No course found with CRN: " + c);
    		
    	}
    	else {
    		
    		boolean deleted = course.getEnrolled().delete(s);
    		
    		if (deleted && !course.getWaitingList().isEmpty()) {
    			Student waiting = course.getWaitingList().dequeue();
    			course.getEnrolled().insert(waiting.getId(), waiting);
    			
    		}
    		if (!deleted) {
    			throw new IllegalArgumentException("No student found with id:" + s);
    		}
    		
    	}
    	
    }
    
    public void raiseCapacity(int c, int r) {
    	
    	Course course  = search(c);
    	
    	if (course == null) {
    		
    		throw new IllegalArgumentException("No course found with CRN: " + c);
    		
    	}
    	
    	course.setCapacity(course.getCapacity()+r);
    	
    	int moved = 0;
    	
    	while (!course.getWaitingList().isEmpty() && moved < r) {
    	    
    		Student waiting = course.getWaitingList().dequeue();
    	    course.getEnrolled().insert(waiting.getId(), waiting);
    	    moved++;
    	
    	}
    	
    }
    
    public void printStudents(int n) {
    	
    	Course course = search(n);
    	
    	if (course == null) {
    		
    		throw new IllegalArgumentException("No course found with CRN: " + n);
    		
    	}
    	
    	course.getEnrolled().traverse(2);
    	
    	
    }
}

