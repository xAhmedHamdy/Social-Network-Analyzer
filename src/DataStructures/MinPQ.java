package DataStructures;

public class MinPQ<T extends Comparable<T>> {
    private T[] pq;
    private int size=0;

    public MinPQ() {
        pq = (T[]) new Comparable[2];
    }

    public T min(){
        if(isEmpty()) throw new java.util.NoSuchElementException("queue is empty");
        return pq[0];
    }


    private void swim(int node){

        while(node>0  ){
            int parent=(node-1)/2;
            if(!greater(parent,node)){
                break;
            }
            exch(parent,node);
            node=parent;


        }
    }
    private void sink(int parent){
        while(((2 * parent) + 1) <= (size - 1)){
            int j=2*parent+1;
            if(j<size-1 && greater(j,j+1)) j++;
            if(!greater(parent,j)) break;
            exch(parent,j);
            parent=j;

        }
    }
    public void insert(T val){
        if(val ==null) throw new IllegalArgumentException(" can't accept a null value");
        if(size==pq.length) resize(2* pq.length);
        pq[size++]=val;
        swim(size-1);
//        System.out.println("After inserting " + val +
//                ": " + java.util.Arrays.toString(pq));

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }



    public T delMin(){
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("queue is empty");
        }
        T min=pq[0];
        exch(0,size-1);
        pq[--size]=null;
        sink(0);
        if(size>0 && size==(pq.length/4)) resize((pq.length/2));

        return min;
    }



    private void resize(int capacity){
     T[] copy=(T[]) new Comparable[capacity];
     for(int i=0;i<size; i++){
         copy[i]=pq[i];

     }
     pq=copy;

    }

    private  boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }


    private void exch(int i,int j){
        T temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }


}
