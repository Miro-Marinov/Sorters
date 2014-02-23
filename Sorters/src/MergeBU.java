import java.util.Arrays;

public class MergeBU
{
    public MergeBU(){ }

    public static Comparable[] mergeBU(Comparable[] a) {
       //System.out.println("a: " + Arrays.toString(a));
       split(a);
       return a;
    }
   
    private static void split(Comparable[] a) {
       int size = a.length;
       // splitSize
       for(int splitSize = 1 ; splitSize < size ; splitSize *= 2) {            
           int lo = 0;
           int hi = Math.min(2*splitSize-1, size - 1);
           while(hi < size) { 
                // mid is not really mid (:
                int mid = lo + splitSize - 1;
                if(mid+1 <= hi && a[mid].compareTo(a[mid+1]) > 0) mergeBU(a, lo, hi, mid);
                if(hi == size - 1)break;
                lo = lo + 2*splitSize;
                hi = Math.min(hi + 2*splitSize, size - 1);
            }           
        }           
    }
    
    private static void mergeBU(Comparable[] a, int lo, int hi, int mid)
    {
       /* copy into auxilary array - reason mergeBU is not so good */
       Comparable[] b = Arrays.copyOfRange(a, lo, hi + 1);
       
       int loB = 0;
       int hiB = b.length - 1;
       int midB = mid - lo;

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
                            split(2,4) mergeBU(2,4) return;
                                split(0,1) mergeBU (0,1) return;
                                split(2,2) return;
                                    split(0,0) return;
                                    split(1,1) return;
                                    .
                                    .
                                                                
*/                                 