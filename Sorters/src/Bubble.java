public class Bubble
{

    public Bubble(){    }

    public static Comparable[] bubble(Comparable[] a) {
        boolean anyChange; 
            //after every iteration heaviest element is at its spot, ligher move 1 to the left
        int right = a.length - 1 ;    
        for(int i= right ; true ; i = right){
            anyChange = false;
            for(int j = 0 ; j < i ; j ++) 
                if(a[j].compareTo(a[j+1]) > 0) {
                    swap(a, j, j + 1);
                    right = j ; //no need to check after last swap index
                    anyChange = true; 
                }
            if(!anyChange) return a; //if on last iteration no changes - return
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
