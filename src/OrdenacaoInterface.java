import java.util.List;

public interface OrdenacaoInterface {
    void swap(List<Filme> filmes, int left, int right);
    void swap(Filme[] filmes, int left, int right);
    int partition(Filme[] filmes, int left, int right);
    int partition(List<Filme> filmes, int left, int right);
}
