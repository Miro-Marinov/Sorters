import java.util.Stack;
public class Shell
{

    public Shell(){    }

    public static Comparable[] shell(Comparable[] a) {
        int n = a.length;
        Stack<Integer> steps = new Stack<Integer>();
        for(int i = 1 ; i < n/3 ; i = i*3 + 1)
            steps.push(i);
        
        while(!steps.empty()) {
            int step = steps.pop();
            for(int i  = step ; i < n; i += step){
                for(int j = i ; j >= step && a[j-step].compareTo(a[j]) > 0; j-=step) 
                        swap(a, j-step, j);
            }       
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
