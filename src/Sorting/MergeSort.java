package Sorting;

public class MergeSort<T extends Comparable<T>> {

    public void sort(Comparable[] a){
        T[] aux =(T[]) new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }


    private void sort(Comparable[] a,Comparable[]aux,int l,int r){
        if(l<r){
            int mid =(l+r)/2;
            sort(a,aux,l,mid);
            sort(a,aux,mid+1,r);
            merge(a,aux,l,mid,r);

        }
    }
    private void merge(Comparable[] a,Comparable[]aux,int l,int mid,int r){
        int i=l,j=mid+1,k=i;
        for(int m=l;m<=r;m++){
            aux[m]=a[m];
        }
        for(;k<r+1;k++){
            if(i>mid){a[k]=aux[j++];}
            else if (j>r) {
                a[k]=aux[i++];
            } else if(aux[i].compareTo(aux[j])<=0){ a[k]=aux[i++];}
            else{a[k]=aux[j++];
                }

        }


    }


}
