import java.util.Collections;
import java.util.List;

public class Ordenacao implements OrdenacaoInterface{
    public void bubbleSort(Filme[] filmes) {
        int n = filmes.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (filmes[j].compareTo(filmes[j + 1]) > 0)
                    swap(filmes, i, j);
    }
    @Override
    public void swap(Filme A[], int i, int j){
        Filme temp = A[j];
        A[j] = A[j + 1];
        A[j + 1] = temp;
    }
    @Override
    public void swap(List<Filme> A, int i, int j){
        Filme temp = A.get(j);
        A.add(j, A.get(j + 1));
        A.add(j + 1, temp);
    }

    public void mergeSort(Filme[] filmes){
        int n = filmes.length;
        if (n < 2){
            return;
        }
        int midIndex = n / 2;
        Filme[] leftHalf = new Filme[midIndex];
        Filme[] rightHalf = new Filme[n - midIndex];

        for (int i = 0; i < midIndex; i++)
            leftHalf[i] = filmes[i];

        for (int i = midIndex; i < n; i++)
            rightHalf[i - midIndex] = filmes[i];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(filmes, leftHalf, rightHalf);
    }
    @Override
    public void merge(Filme[] filmes, Filme[] leftHalf, Filme[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize){
            if (leftHalf[i].compareTo(rightHalf[j]) >= 0){ //return outro < this ? -1 : (outro == this ? 0 : 1);
                filmes[i] = leftHalf[i];
                i++;
            }else{
                filmes[k] = rightHalf[j];
                j++;
            }
            k++;
            while (i < leftSize) {
                filmes[k] = leftHalf[i];
                i++;
                k++;
            }
            while (j < rightSize){
                filmes[k] = rightHalf[j];
                j++;
                k++;
            }
        }
    }
    public void quickSort(Filme[] filmes, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(filmes, left, right);
            quickSort(filmes, left, pivotIndex - 1);
            quickSort(filmes, pivotIndex + 1, right);
        }
    }
    public void quickSortShuffle(List<Filme> filmes, int left, int right){
        Collections.shuffle(filmes);
        if (left < right) {
            int pivotIndex = partition(filmes, left, right);
            quickSortShuffle(filmes, left, pivotIndex - 1);
            quickSortShuffle(filmes, pivotIndex + 1, right);
        }
    }
    @Override
    public int partition(Filme[] filmes, int left, int right){
        Filme pivot = filmes[left];
        int i = left + 1;
        int j = right;
        while ( i <= j ) {
            if ( filmes[i].compareTo(pivot) >= 0 ) i++; //return outro < this ? -1 : (outro == this ? 0 : outro > this = 1) ;
            else if ( filmes[j].compareTo(pivot) < 0 ) j--;
            else swap(filmes, i, j);
        }
        swap(filmes, left, j);
        return j;
    }
    @Override
    public int partition(List<Filme> filmes, int left, int right){
        Filme pivot = filmes.get(left);
        int i = left + 1;
        int j = right;
        while ( i <= j ) {
            if ( filmes.get(i).compareTo(pivot) <= 0 ) i++; //return outro < this ? -1 : (outro == this ? 0 : 1);
            else if ( filmes.get(j).compareTo(pivot) > 0 ) j--;
            else swap(filmes, i, j);
        }
        swap(filmes, left, j);
        return j;
    }
}
