public class Comb
{

    private int x;

    public Comb() {}

    public static Comparable[] comb(Comparable[] a){
        int n = a.length;
        int gap = n;
        boolean swap = false;
        do {
            gap = (int) (gap/1.3);
            swap = false;
            if (gap < 1) gap = 1;
            for(int i = 0 ; i < n - gap; i ++){
                if(a[i].compareTo(a[i + gap]) > 0){
                    swap(a, i, i + gap);
                    swap = true;
                }
            }
        }while(gap != 1 || swap != false);
        
        return a;
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
