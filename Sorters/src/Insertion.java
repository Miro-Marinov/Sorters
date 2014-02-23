public class Insertion
{

    public Insertion(){    }

    public static Comparable[] insertion(Comparable[] a) {
        int n = a.length;
        for(int i = 1 ; i < n; i ++){
            for(int j = i  ; j >= 1 && a[j-1].compareTo(a[j]) > 0; j --) 
                    swap(a, j - 1, j);
        }    
        return a;
    }
    
    private static void swap (Comparable[] a, int i, int j) {
        if (i < 0 || j < 0) 
            throw new IndexOutOfBoundsException("i and j indexes must be nonegative");
        if (i >= a.length || j >= a.length)
            throw new IndexOutOfBoundsException("i and j indexes out of bounds");
        
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }    
}
