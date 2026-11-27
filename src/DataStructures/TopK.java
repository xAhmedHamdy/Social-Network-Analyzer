package DataStructures;

public class TopK {
    public static <T extends Comparable<T>> T[] topK(T[] items,T[] result, int k) {
        MinPQ<T> pq= new MinPQ<>();
        for(T item: items){
            pq.insert(item);
            if(pq.size()>k) pq.delMin();
        }

        for(int i=pq.size()-1;i>=0;i--){
            result[i]=pq.delMin();
        }
        return result;
    }
}
