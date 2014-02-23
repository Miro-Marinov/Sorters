import java.util.Arrays;
public class SortComparator
{
    // instance variables - replace the example below with your own
   /* private static Comparable[] a = new Comparable[] {
        41, 467, 334, 0, 169, 224, 478, 358, 462, 464, 205, 145, 281, 327, 461,
        491, 495, 442, 327, 436, 391, 104, 402, 153, 292, 382, 421, 216, 218, 395,
        447, 226, 271, 38, 369, 412, 167, 299, 35, 394, 203, 311, 322, 333, 173,
        164, 141, 211, 253, 368, 47, 144, 162, 257, 37, 359, 223, 241, 29, 278,
        316, 35, 190, 342, 288, 106, 40, 442, 264, 148, 446, 305, 390, 229, 370,
        350, 6, 101, 393, 48, 129, 123, 84, 454, 256, 340, 466, 376, 431, 308,
        444, 439, 126, 323, 37, 38, 118, 82, 429, 41, 333, 115, 139, 158, 204,
        430, 477, 306, 173, 386, 21, 245, 424, 72, 270, 329, 277, 73, 97, 12,
        486, 290, 161, 136, 355, 267, 155, 74, 31, 52, 350, 150, 441, 224, 466,
        430, 107, 191, 7, 337, 457, 287, 253, 383, 445, 409, 209, 258, 221, 88,
        422, 446, 6, 30, 413, 168, 400, 91, 262, 155, 410, 359, 124, 37, 48,
        483, 95, 41, 102, 350, 291, 336, 374, 20, 96, 21, 348, 199, 168, 484,
        281, 234, 53, 499, 418, 438, 400, 288, 127, 467, 228, 393, 148, 483, 307,
        421, 310, 117, 313, 14, 309, 116, 435, 451, 100, 249, 19, 56, 298, 303,
        224, 8, 344, 109, 489, 202, 195, 485, 93, 343, 23, 87, 314, 3, 448,
        200, 458, 118, 80, 296, 298, 281, 89, 298, 9, 157, 472, 122, 38, 292,
        38, 179, 190, 157, 458, 191, 315, 388, 156, 11, 202, 134, 272, 55, 328,
        146, 362, 386, 375, 433, 369, 142, 344, 416, 381, 498, 322, 151, 21, 199,
        57, 476, 392, 389, 75, 212, 100, 10, 3, 369, 361, 188, 401, 289, 255,
        423, 2, 85, 182, 285, 88, 426, 117, 257, 332, 432, 169, 154, 221, 189,
        476, 329, 368, 192, 425, 55, 434, 49, 441, 12, 145, 60, 218, 253, 139,
        423, 279, 496, 187, 29, 49, 437, 366, 449, 193, 195, 297, 416, 286, 105,
        488, 282, 455, 234, 114, 201, 316, 171, 286, 263, 313, 355, 185, 53, 412,
        308, 332, 445, 313, 256, 321, 58, 146, 482, 481, 144, 196, 222, 129, 161,
        35, 450, 173, 466, 44, 159, 292, 439, 253, 24, 154, 10, 245, 149, 186,
        313, 474, 22, 168, 18, 287, 405, 458, 391, 202, 125, 477, 414, 314, 324,
        334, 374, 372, 159, 333, 70, 487, 297, 18, 177, 273, 270, 263, 168, 192,
        485, 102, 480, 213, 127, 302, 99, 27, 125, 43, 424, 23, 472, 61, 181,
        3, 432, 5, 93, 225, 31, 492, 142, 222, 286, 64, 400, 187, 360, 413,
        474, 270, 170, 235, 333, 211, 260, 396, 167, 285, 50, 140, 194, 195, 124,
        19, 125, 76, 194, 158, 302, 371, 466, 178, 93, 351, 484, 18, 464, 119,
        152, 300, 87, 60, 426, 10, 257, 170, 315, 76, 227, 43, 258, 164, 109,
        382, 86, 65, 487, 77, 474, 125, 127, 129, 428, 423, 20, 402, 462, 123,
        96, 237, 261, 195, 25 };*/


        public SortComparator(){}
    private static final int R = 5000;    
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
        }
        System.out.println(name + " exec time: " + (end - start));
        return (end-start);
    }
    
       
    public static void printA(Object[] a) {
        System.out.println(Arrays.toString(a));
    }
    
    private static long curTime() {
        return System.currentTimeMillis();
    }
    

    
}
