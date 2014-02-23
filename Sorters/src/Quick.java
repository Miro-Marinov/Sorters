import java.util.Stack;

class Quick
{
    private static final int CUTOFF = 32;
    public Quick(){ }

    public static Comparable[] quick(Comparable[] a)
    {
        quick(a, 0, a.length -1);
        return a;
    }
    
    private static void quick(Comparable[] a, int lo, int hi) {
        //if(hi - lo <= 512) {shell(a, lo, hi);return;}
        if(lo >= hi) return;
        int pivot = partition(a, lo, hi);
        quick(a, lo, pivot -1);
        quick(a, pivot + 1, hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        swap(a, lo, lo + (hi - lo)/2);
        int pivot = lo;
        
        int left = lo;
        int right = hi + 1;
        while(true) {
            // search for larger on the left (<= seems like the better choice but it's not - the partitions are of much uneven size)
            while(++left <= hi && a[left].compareTo(a[pivot]) < 0);
            // search for smaller on the right (same as above - use > not >=)
            while(--right > lo && a[right].compareTo(a[pivot]) > 0);
            //check for cross
            if(left>=right)break;
            swap(a, left, right);
        }
        swap(a, lo, right);
        return right;
    }
    
    
    public static void shell(Comparable[] a, int lo, int hi) {
        int n = hi-lo;
        Stack<Integer> steps = new Stack<Integer>();
        for(int i = 1 ; i < n/3 ; i = i*3 + 1)
            steps.push(i);
        
        while(!steps.empty()) {
            int step = steps.pop();
            for(int i  = lo + step ; i < hi; i += step){
                for(int j = i ; j >= lo+step && a[j-step].compareTo(a[j]) > 0; j-=step) 
                        swap(a, j-step, j);
            }       
        }
    }
    
    
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

/*
4 1 3 6 7 2 9 5 0 8 swap 6 and 0
4 1 3 0 7 2 9 5 6 8 swap 7 and 2
4 1 3 0 2 7 9 5 6 8 right = 4 left = 5 swap 4 and 2
2 1 3 0 4 7 9 5 6 8 return 4 as the pivot
*/




