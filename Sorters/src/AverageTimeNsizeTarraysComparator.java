import java.util.Random;
import java.util.Arrays;
/**
 * Write a description of class AverageTimeNsizeTarraysComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AverageTimeNsizeTarraysComparator
{
    private static final int algoCount = 15; //number of algorithms to test
    private static final int PRINT = 2; //1 - print once, 0 - print twice, 2 - no print
    private static final int SHOWSLOWER = 1; //1 - don't show slower sorting algorithms, 0 - show them
    private static Random r = new Random();
    private static int R; // the set of distinct possible integers [0, R-1] - for Bucket sort
    public  AverageTimeNsizeTarraysComparator(){}
    
    // N - arrays size, T - number of arrays, R - number of distinct values in [-R/2, R/2)
    public static void testAll(int N, int T, int R)
    {
        System.out.print('\f'); /* clears the screen in blueJ wtf */
        AverageTimeNsizeTarraysComparator.R = R;
        Comparable[] a = new Comparable[N];
        long[] times = new long[algoCount];
        System.out.flush();
        for(int i = PRINT ; i < T + PRINT ; i++){
            /* generate random array */
            for(int j = 0 ; j < N ; j ++)
                a[j] = R/2 - r.nextInt(R);
            
            for(int algo = 0 ; algo < algoCount ; algo ++) {
                switch(algo){
                    case 0 + SHOWSLOWER*algoCount:  times[algo] += testSort("bub", a, i);break; // THESE 
                    case 1 + SHOWSLOWER*algoCount:  times[algo] += testSort("sha", a, i);break; // ALGORITHMS
                    case 2 + SHOWSLOWER*algoCount:  times[algo] += testSort("sel", a, i);break; // ARE
                    case 3 + SHOWSLOWER*algoCount:  times[algo] += testSort("ins", a, i);break; // VERY
                    case 4 + SHOWSLOWER*algoCount:  times[algo] += testSort("she", a, i);break; // SLOW
                    case 5:  times[algo] += testSort("qui", a, i);break;
                    case 6:  times[algo] += testSort("q3w", a, i);break;
                    case 7:  times[algo] += testSort("mer", a, i);break;
                    case 8:  times[algo] += testSort("mbu", a, i);break;
                    case 9:  times[algo] += testSort("hea", a, i);break;
                    case 10: times[algo] += testSort("com", a, i);break;
                    case 11: times[algo] += testSort("buc", a, i);break;
                    case 12: times[algo] += testSort("rct", a, i);break;
                    case 13: times[algo] += testSort("rcm", a, i);break;
                    case 14: times[algo] += testSort("rls", a, i);break;
                }
                
            }
            System.out.println();
        }   
        int algo;
        for( algo = 0 ; algo < algoCount ; algo ++){
            times[algo]/=T;
            if(SHOWSLOWER == 0 || algo >= 5)System.out.print("Average time for: ");
            switch(algo){
                case 0 + SHOWSLOWER*algoCount:  System.out.print("Bubble    ");break; // THESE 
                case 1 + SHOWSLOWER*algoCount:  System.out.print("Shaker    ");break; // ALGORITHMS
                case 2 + SHOWSLOWER*algoCount:  System.out.print("Selection ");break; // ARE
                case 3 + SHOWSLOWER*algoCount:  System.out.print("Insertion ");break; // VERY
                case 4 + SHOWSLOWER*algoCount:  System.out.print("Shell     ");break; // SLOW
                case 5:  System.out.print("Quick     ");break;
                case 6:  System.out.print("Quick3way ");break;
                case 7:  System.out.print("Merge     ");break;
                case 8:  System.out.print("MergeBU   ");break;
                case 9:  System.out.print("Heap      ");break;
                case 10: System.out.print("Comb      ");break;
                case 11: System.out.print("Bucket    ");break;
                case 12: System.out.print("RadixCnt  ");break;
                case 13: System.out.print("RadixCmlt ");break;
                case 14: System.out.print("RadixLSB  ");break;
            }
            if(SHOWSLOWER == 0 || algo >= 5)System.out.println(" - " + times[algo]);
        }
    }
    
    
    public static long testSort (String sortAbr, Comparable[] a, int print){ 
        long start = 0 ;
        long end = 0 ;
        String name = null;
        //printA(a);
        switch(sortAbr){
            case "bub": 
            start = curTime();
            if(print < 2)printA(Bubble.bubble(Arrays.copyOf(a, a.length)));
            else Bubble.bubble(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Bubble";
            break;
            
            case "sha": 
            start = curTime();
            if(print < 2)printA(Shake.shake(Arrays.copyOf(a, a.length))); 
            else Shake.shake(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Shaker";
            break;
            
            case "sel": 
            start = curTime();
            if(print < 2)printA(Selection.selection(Arrays.copyOf(a, a.length))); 
            else Selection.selection(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Selection";
            break;
            
            case "ins": 
            start = curTime();
            if(print < 2)printA(Insertion.insertion(Arrays.copyOf(a, a.length)));
            else Insertion.insertion(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Insertion";
            break;
            
            case "she": 
            start = curTime();
            if(print < 2)printA(Shell.shell(Arrays.copyOf(a, a.length))); 
            else Shell.shell(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Shell";
            break;
            
            case "qui": 
            start = curTime();
            if(print < 2)printA(Quick.quick(Arrays.copyOf(a, a.length)));
            else Quick.quick(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Quick";
            break;
            
            case "q3w": 
            start = curTime();
            if(print < 2)printA(Quick3way.quick3way(Arrays.copyOf(a, a.length))); 
            else Quick3way.quick3way(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Quick3way";
            break;
            
            case "mer": 
            start = curTime();
            if(print < 2)printA(Merge.merge(Arrays.copyOf(a, a.length)));
            else Merge.merge(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Merge";
            break;
            
            case "mbu": 
            start = curTime();
            if(print < 2)printA(MergeBU.mergeBU(Arrays.copyOf(a, a.length)));
            else MergeBU.mergeBU(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "MergeBU";
            break;
            
            case "hea": 
            start = curTime();
            if(print < 2)printA(Heap.heap(Arrays.copyOf(a, a.length)));
            else Heap.heap(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Heap";
            break;
            
            case "com": 
            start = curTime();
            if(print < 2)printA(Comb.comb(Arrays.copyOf(a, a.length)));
            else Comb.comb(Arrays.copyOf(a, a.length));
            end = curTime();
            name = "Comb";
            break;
            
            case "buc": 
            start = curTime();
            if(print < 2)printA(Bucket.bucket(Arrays.copyOf(a, a.length), R));
            else Bucket.bucket(Arrays.copyOf(a, a.length), R);
            end = curTime();
            name = "Bucket";
            break;
            
            case "rct": 
            start = curTime();
            if(print < 2)printA(Radix.radixCount(Arrays.copyOf(a, a.length), R));
            else Radix.radixCount(Arrays.copyOf(a, a.length), R);
            end = curTime();
            name = "RadixCnt";
            break;
            
            case "rcm": 
            start = curTime();
            if(print < 2)printA(Radix.radixComul(Arrays.copyOf(a, a.length), R));
            else Radix.radixComul(Arrays.copyOf(a, a.length), R);
            end = curTime();
            name = "RadixCmlt";
            break;
            
            case "rls": 
            start = curTime();
            if(print < 2)printA(Radix.radixLSB(Arrays.copyOf(a, a.length), R));
            else Radix.radixLSB(Arrays.copyOf(a, a.length), R);
            end = curTime();
            name = "RadixLSB";
            break;
        }

        //System.out.println("SAME1?: " + Arrays.equals( Quick.quick(Arrays.copyOf(a, a.length)),Merge.merge(Arrays.copyOf(a, a.length)) ));
        //System.out.println("SAME2?: " + Arrays.equals( Radix.radixLSB(Arrays.copyOf(a, a.length), R),Merge.merge(Arrays.copyOf(a, a.length))));
        //System.out.println("SAME3?: " + Arrays.equals( Radix.radixCount(Arrays.copyOf(a, a.length), R), Quick.quick(Arrays.copyOf(a, a.length))));
        //System.out.println("SAME4?: " + Arrays.equals( Radix.radixComul(Arrays.copyOf(a, a.length), R), Quick.quick(Arrays.copyOf(a, a.length))));
        //System.out.println("SAME5?: " + Arrays.equals( Heap.heap(Arrays.copyOf(a, a.length)), Quick.quick(Arrays.copyOf(a, a.length))));
        System.out.println(name + " exec time: " + (end - start));
        return (end-start);
    }
    
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
       
    public static void printA(Object[] a) {
        System.out.println(Arrays.toString(a));
    }
    
    private static long curTime() {
        return System.currentTimeMillis();
    }
    
    public static void main(String[] args) {
      AverageTimeNsizeTarraysComparator.testAll(500000, 5, 100000);
  }
}
