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
    public void swapQuick(Filme[] A, int i, int j) {
        Filme temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    @Override
    public void swap(List<Filme> A, int i, int j){
        Filme temp = A.get(j);
        A.add(j, A.get(j + 1));
        A.add(j + 1, temp);
    }

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
    public int partition(Filme[] filmes, int left, int right) {
        Filme pivot = filmes[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            // Encontra o primeiro elemento à direita que deve ser à esquerda do pivô
            while (i <= j && filmes[i].compareTo(pivot) < 0) {
                i++;
            }
            // Encontra o primeiro elemento à esquerda que deve ser à direita do pivô
            while (i <= j && filmes[j].compareTo(pivot) >= 0) {
                j--;
            }
            // Se ainda houver elementos a serem trocados
            if (i < j) {
                swapQuick(filmes, i, j);
                i++;
                j--;
            }
        }
        // Posiciona o pivô na posição correta
        swapQuick(filmes, left, j);
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
