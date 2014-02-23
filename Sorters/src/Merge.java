import java.util.Arrays;

public class Merge
{
    public Merge(){ }

    public static Comparable[] merge(Comparable[] a)
    {
       split(a, 0, a.length - 1);
       return a;
    }
   
    private static void split(Comparable[] a, int lo, int hi)
    {
       if(lo >= hi) return;
       int mid = lo + (hi - lo)/2;
       
       split(a, lo, mid);
       split(a, mid + 1, hi);
       //merge only if nesessary
       if(a[mid].compareTo(a[mid+1]) > 0)merge(a, lo, hi);
    }
    
    private static void merge(Comparable[] a, int lo, int hi)
    {
       /* copy into auxilary array - reason merge is not so good */
       Comparable[] b = Arrays.copyOfRange(a, lo, hi + 1);

       int loB = 0;
       int hiB = b.length - 1;
       int midB = (hiB-loB)/2;

       int left = loB;
       int right = midB + 1;
       
       for(int i = lo ; i <= hi ; i ++){
           if(left > midB)                          a[i] = b[right++];
           else if(right > hiB)                     a[i] = b[left++] ;
           else if(b[left].compareTo(b[right]) < 0) a[i] = b[left++];
           else                                     a[i] = b[right++];
        }
    }
}


/*
0 1 2 3 4 5 6 7 8 9

4 1 3 6 7 2 9 5 0 8 split(0, 9) - 
                        split(0, 4) 
                        split(5, 9)
                            split(0,2)
                            split(2,4) merge(2,4) return;
                                split(0,1) merge (0,1) return;
                                split(2,2) return;
                                    split(0,0) return;
                                    split(1,1) return;
                                    .
                                    .
                                                                
*/                                 