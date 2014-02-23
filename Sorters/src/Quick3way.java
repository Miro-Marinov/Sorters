import java.util.Stack;

class Quick3way
{
    private static final int CUTOFF = 32;
    public Quick3way(){ }

    public static Comparable[] quick3way(Comparable[] a)
    {
        quick3way(a, 0, a.length -1);
        return a;
    }
    
    private static void quick3way(Comparable[] a, int lo, int hi) {
        //if(hi - lo <= 512) {shell(a, lo, hi);return;}
        if(lo >= hi) return;
        
        /* partition here */
        swap(a, lo, lo + (hi - lo)/2); //take mid as pivot
        int pivot = lo;
        
        int less = lo + 1;
        int grtr = hi;
        
        for(int i = less ; i <=  grtr ; ) {
            int cmp = a[i].compareTo(a[pivot]);          
            if(cmp < 0)      swap(a, i++, less++); // swap with an equal element - less part grow (increment i since we know its an equal element)
            else if(cmp > 0) swap(a, i, grtr--);   // swap with element 1 to the left of the greater part, we don't increment i since we don't know what element it is
            else             i++;                  // if greater just let the equal part grow    
        }
            
        swap(a, less-- - 1, pivot); // last swap with less element to increase the equal part
        
        quick3way(a, lo, less - 1);
        quick3way(a, grtr + 1, hi);
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




