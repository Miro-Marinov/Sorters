import java.util.Arrays;
public class Heap
{
    // instance variables - replace the example below with your own
    private int x;

    public Heap(){}

    public static Comparable[] heap(Comparable []a)
    {
        heaplify(a);
        sort(a);
        return a;
    }
    
    private static void heaplify(Comparable[] a) {
        int n = a.length;
        for (int i = n/2-1 ; i >= 0 ; i --)
            sink(a, i);
    }
    
        private static void sort(Comparable[] a) {
        int rear = a.length - 1;
        while(rear > 0) {
            swap(a, 0, rear);
            sink(a, 0, rear--);
        }
    }
    
    // swim up the entire heap tree
    private static void swim(Comparable []a, int v) {
        // parent = ( node -1 ) /2
        while(v > 0) {
            int parent = (v - 1)/2;
            if(a[parent].compareTo(a[v]) >= 0)break; //no need to swim any further
            swap(a, parent, v);
            v = parent;
        }
    }
    
    // sink down the entire heap tree
    private static void sink(Comparable []a, int v){
        int n = a.length;
        // lChild = node*2 + 1, rChild = node*2 + 2
        // while node v has a child
        while(v*2 + 1 < n) {
            int lChild  = v*2 + 1;
            int rChild = v*2 + 2;
            
            int select = lChild;
            //select the bigger child
            if(rChild < n && (a[lChild].compareTo(a[rChild]) < 0)) select ++;
            if(a[v].compareTo(a[select]) >= 0)break; //no need to sink any further
            swap(a, v, select);
            v = select;
        }
    }
    
    // sink down part of the heap tree (n denotes what is the size of the subtree considered) 
    // if n is less than a.length then the subtree is formed by removing elements on the right (leafs)
    // of the array
    private static void sink(Comparable []a, int v, int n){
        // lChild = node*2 + 1, rChild = node*2 + 2
        // while node v has a child
        while(v*2 + 1 < n) {
            int lChild  = v*2 + 1;
            int rChild = v*2 + 2;
            
            int select = lChild;
            //select the bigger child
            if(rChild < n && (a[lChild].compareTo(a[rChild]) < 0)) select ++;
            if(a[v].compareTo(a[select]) >= 0) break;
            swap(a, v, select);
            v = select;
        }
    }
    
    // swap...
    private static void swap (Object[] a, int i, int j) {
        if (i < 0 || j < 0) 
            throw new IndexOutOfBoundsException("i and j indexes must be nonegative");
        if (i >= a.length || j >= a.length)
            throw new IndexOutOfBoundsException("i and j indexes out of bounds");
        
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }   

}
