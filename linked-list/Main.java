public class Main{
    public static void main(String[] args) {
        LinkedList[] llArr = {
            new LinkedList(3, 2),  // idx0 (data 3)  -> next larger is 4 at idx2
            new LinkedList(1, 3),  // idx1 (data 1)  -> next larger is 2 at idx3
            new LinkedList(4, -1), // idx2 (data 4)  -> end (-1)
            new LinkedList(2, 0)   // idx3 (data 2)  -> next larger is 3 at idx0
        };

        // print this logically sorted list in physical sorted order
    }
}

class LinkedList{
    int data;
    int ni;

    LinkedList(int d, int n){
        data = d;
        ni = n;
    }
}