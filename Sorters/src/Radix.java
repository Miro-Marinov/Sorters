import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;

public class Radix
{
    
    public Radix(){ }

    public static Comparable[] radixCount(Comparable[] a, int M)
    {
        /* create the count - shit is same as bucket*/
        int N = a.length;
        int[] count = new int[M+1];
        
        /* frequency count (have to do shitty math because of negative indexing */
        for(int i = 0 ; i < N ; i ++)
             count[(Integer)a[i] + M/2 + M%2 - 1]++;

        /* retrieve each of the elements of each Radix */
        int curInd = 0;
        for(int i = 0 ; i < M ; i ++){
            for(int j = 0 ; j < count[i] ; j ++)
                a[curInd++] = i - M/2 - M%2 + 1;
            }
        
        return a;
    }
    
    
    public static Comparable[] radixComul(Comparable[] a, int M)
    {
        /* create the count */
        int N = a.length;
        int[] count = new int[M+1];
        Comparable[] temp = new  Comparable[N];
        
        /* frequency count (have to do shitty math because of negative indexing */
        for(int i = 0 ; i < N ; i ++)
             count[(Integer)a[i] + M/2 + M%2 - 1 + 1]++;
        /* comulative count */
        for(int i = 1 ; i < M + 1 ; i ++)
             count[i]+=count[i-1];
        
        /* sorted array using comulative count */
        for(int i = 0 ; i < N ; i ++)
            temp[count[(Integer)a[i] + M/2 + M%2 - 1]++] =  a[i];
        
        /* copy back */
        for(int i = 0 ; i < N ; i ++)    
            a[i] = temp[i];
        return a;
    }
    
    public static Comparable[] radixLSB(Comparable[] a, int M)
    {
        /* create the count */
        int N = a.length;
        int saveM = M;
        int curDigit = 0;
        
        //since digits array starts from 0 we need num of actual digits - 1    
        while(saveM > 0){
            
            ArrayList<Comparable>[] buckets = new ArrayList[10]; // 10 digits
            for(int i = 0 ; i < 10 ; i ++)
                buckets[i] = new ArrayList();
            /* fill bucket for each digit */
            for(int i = 0 ; i < N ; i ++){
                 //String number = String.valueOf((int)a[i] + M/2 + M%2 - 1);
                 //int len = number.length();
                 //if(len - 1 - curDigit >=0) buckets[Character.digit(number.charAt(len - 1 - curDigit), 10)].add(a[i]);
                 //else buckets[0].add(a[i]);
                 
                 buckets[getDigit(( (Integer)a[i] + M/2 + M%2 - 1 ), curDigit)].add(a[i]);
            }
            /* use buckets for each digit to sort in terms of digit */     
            int curInd = 0;
             for(int i = 0 ; i < 10 ; i ++){
                   for(Comparable num : buckets[i])
                     a[curInd++] = num;
            }
            saveM/=10;
            curDigit++;
        }
        return a;
    }
    
    private static int getDigit(int number, int indexFromLeft){
        return (number/((int)Math.pow(10,indexFromLeft)))%10;
    }

}


/*
 N = 10
 M = 6 values in [-2;3]
       freq    comul   temp
                1       -2
-2      2       4       
 0      1       3        0
 0      2       5        0
 3      1       6
 2      2       8
 1      2       10
-2
 2
 3
-1

*/