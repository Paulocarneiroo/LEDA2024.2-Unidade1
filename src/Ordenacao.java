import java.util.List;

public class Ordenacao implements Ordenacao_IF{
    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        return false;
    }

    //BubbleSort
    @Override
    public void bubbleSort(Filme[] filmes) {
        int n = filmes.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (filmes[j].compareTo(filmes[j + 1]) > 0)
                    swap(filmes, i, j);
    }
    private void swap(Filme A[], int i, int j){
        Filme temp = A[j];
        A[j] = A[j + 1];
        A[j + 1] = temp;
    }

    //MergeSort
    @Override
    public void mergeSort(Filme[] filmes) {
        if (filmes.length <= 1) {
            return;
        }
        int meio = filmes.length / 2;
        Filme[] esquerda = new Filme[meio];
        Filme[] direita = new Filme[filmes.length - meio];

        System.arraycopy(filmes, 0, esquerda, 0, meio);
        System.arraycopy(filmes, meio, direita, 0, filmes.length - meio);

        mergeSort(esquerda);
        mergeSort(direita);

        Filme[] resultado = merge(esquerda, direita);
        System.arraycopy(resultado, 0, filmes, 0, resultado.length);
    }
    public Filme[] merge(Filme[] esquerda, Filme[] direita) {
        Filme[] resultado = new Filme[esquerda.length + direita.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i].compareTo(direita[j]) <= 0) {
                resultado[k++] = esquerda[i++];
            } else {
                resultado[k++] = direita[j++];
            }
        }
        while (i < esquerda.length) {
            resultado[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            resultado[k++] = direita[j++];
        }
        return resultado;
    }

    //QuickSort
    @Override
    public void quickSort(Filme[] filmes, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionQuick(filmes, left, right);
            quickSort(filmes, left, pivotIndex - 1);
            quickSort(filmes, pivotIndex + 1, right);
        }
    }
    public int partitionQuick(Filme[] filmes, int left, int right) {
        Filme pivot = filmes[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && filmes[i].compareTo(pivot) < 0) {
                i++;
            }
            while (i <= j && filmes[j].compareTo(pivot) >= 0) {
                j--;
            }
            if (i < j) {
                swapQuick(filmes, i, j);
                i++;
                j--;
            }
        }
        swapQuick(filmes, left, j);
        return j;
    }
    public void swapQuick(Filme[] A, int i, int j) {
        Filme temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //QuickSortRandom
    @Override
    public void quickSortRandom(Filme[] filmes, int left, int right){
        //TODO
    }
    public int partitionQuickRandom(List<Filme> filmes, int left, int right){
        return 0;
        //TODO
    }
    public void swapQuickRandom(List<Filme> A, int i, int j){
        //TODO
    }

    //CountingSort
    @Override
    public void countingSort(Filme[] filmes) {
        //TODO
    }
}
