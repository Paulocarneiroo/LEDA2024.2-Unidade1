import java.util.List;

public interface Ordenacao_IF {

    public boolean checaVetorOrdenado(Filme[] filmes);

    public void bubbleSort(Filme[] filmes);

    public void quickSort(Filme[] filmes, int left, int right);

    public void quickSortRandom(List<Filme> filmes, int left, int right); // Versão do slide + Shuffle (pivô aleatório)

    public void mergeSort(Filme[] filmes);

    public void countingSort(Filme[] filmes, int k);

}