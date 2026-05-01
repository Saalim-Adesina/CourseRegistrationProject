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

    public void addStudent(Student s){

    }
}

