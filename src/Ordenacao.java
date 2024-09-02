import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    public void quickSortRandom(List<Filme> filmes, int left, int right){
        Collections.shuffle(filmes);
        if (left < right) {
            int pivotIndex = partitionQuickRandom(filmes, left, right);
            quickSortRandom(filmes, left, pivotIndex - 1);
            quickSortRandom(filmes, pivotIndex + 1, right);
        }
    }
    public int partitionQuickRandom(List<Filme> filmes, int left, int right){
        Random random = new Random();
        Filme pivot = filmes
                .get(random.nextInt(right - left + 1) + left);
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && filmes.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (i <= j && filmes.get(j).compareTo(pivot) >= 0) {
                j--;
            }
            if (i < j) {
                swapQuickRandom(filmes, i, j);
                i++;
                j--;
            }
        }
        swapQuickRandom(filmes, left, j);
        return j;
    }
    public void swapQuickRandom(List<Filme> A, int i, int j) {
        Filme temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    //CountingSort
    @Override
    public void countingSort(Filme[] filmes, int maxNota) {
        int n = filmes.length;
        Filme[] output = new Filme[n];
        int[] count = new int[maxNota + 1];

        for (int i = 0; i <= maxNota; i++) {
            count[i] = 0;
        }

        for (int j = 0; j < n; j++) {
            count[filmes[j].getNota()]++;
        }

        for (int i = maxNota - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        for (int j = n - 1; j >= 0; j--) {
            output[count[filmes[j].getNota()] - 1] = filmes[j];
            count[filmes[j].getNota()]--;
        }

        for (int i = 0; i < n; i++) {
            filmes[i] = output[i];
        }
    }
}
