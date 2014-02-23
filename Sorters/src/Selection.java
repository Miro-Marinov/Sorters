public class Selection
{

    public Selection(){}

    public static Comparable[] selection(Comparable[] a) {
        int n = a.length;
        for(int i = 0 ; i < n - 1 ; i ++) {
            int min = i;
            for(int j = i + 1 ; j < n ; j ++)
                if(a[j].compareTo(a[min]) < 0) min = j;
            swap(a, i, min);
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
