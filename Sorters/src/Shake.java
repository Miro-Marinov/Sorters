public class Shake
{

    public Shake(){    }

    public static Comparable[] shake(Comparable[] a) {
        int left = 0;
        int right = a.length - 1 ;
        int lastSwap = right;
        boolean anyChange; 
        while(true){
                anyChange = false;
                for(int i = left ; i < right ; i ++) 
                    if(a[i].compareTo(a[i+1]) > 0) {
                        swap(a, i, i + 1);
                        lastSwap = i; //no need to check after last swap index
                        anyChange = true; 
                    }
                if(!anyChange) return a; //if on last iteration no changes - return
                right = lastSwap;
               
                anyChange = false;
                for(int i = right-1 ; i >= left ; i --) 
                    if(a[i].compareTo(a[i+1]) > 0) {
                        swap(a, i, i + 1);
                        lastSwap = i + 1; //no need to check after last swap index
                        anyChange = true; 
                    }
                if(!anyChange) return a; //if on last iteration no changes - return
                left = lastSwap;
            }     
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