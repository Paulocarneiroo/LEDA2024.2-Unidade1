/*
 * Interface para implementação da classe "Busca".
 * Os métodos booleanos devem retornar 'false' se 'notas' não estiver no vetor 'filmes'.
 */
public interface Busca_IF {
    boolean checaVetorOrdenado(Filme[] filmes);

    Filme buscaLinear_iterativa(Filme[] filmes, String filme) throws Exception;

    Filme buscaLinear_recursiva(Filme[] filmes, String filme) throws Exception;

    Filme buscaBinaria_iterativa(Filme[] filmes, String filme) throws Exception;

    Filme buscaBinaria_recursiva(Filme[] filmes, String filme) throws Exception;

    /*
     * O método buscaLinear_iterativa_duasPontas é opcional.
     * Porém, caso não forem usa-lo, sigam a interface, coloquem o método no código e deixem apenas um return false.
     */
    Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, String filme) throws Exception;
}