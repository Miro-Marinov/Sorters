import java.util.LinkedList;

public class Bucket
{
    
    public Bucket(){ }

    public static Comparable[] bucket(Comparable[] a, int M)
    {
        /* create the buckets */
        LinkedList<Comparable>[] buckets = (LinkedList<Comparable>[]) new LinkedList[M];
        for(int i = 0 ; i < M ; i ++)
            buckets[i] = new LinkedList<Comparable>();
        
        /* add each element in its bucket (have to do shitty math because of negative indexing */
        for(int i = 0 ; i < a.length ; i ++)
            buckets[(Integer)a[i] + M/2 + M%2 - 1].add(a[i]);
        
        /* retrieve each of the elements of each bucket */
        int curInd = 0;
        for(int i = 0 ; i < M ; i ++)
            while(buckets[i].size() > 0){
                a[curInd++] = buckets[i].remove();
            }
        
        return a;
    }
}
