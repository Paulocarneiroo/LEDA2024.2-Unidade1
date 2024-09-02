public class Busca implements Busca_IF{
    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 1; i < filmes.length; i++)
            if (filmes[i - 1].compareTo(filmes[i]) > 0)
                return false;
        return true;
    }

    @Override
    public Filme buscaLinear_iterativa(Filme[] filmes, String filme) throws Exception {
        for (Filme f : filmes){
            if (f.getNome().equalsIgnoreCase(filme)){
                return f;
            }
        }
        throw new Exception("Filme não encontrado");
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, String nomeFilme) throws Exception {
        return buscaLinearRecursivaHelper(filmes, nomeFilme, 0);
    }

    private Filme buscaLinearRecursivaHelper(Filme[] filmes, String nomeFilme, int index) throws Exception {
    if (index >= filmes.length) {
        throw new Exception("Filme não encontrado");
    }
    if (filmes[index].getNome().equalsIgnoreCase(nomeFilme)) {
        return filmes[index];
    }
    return buscaLinearRecursivaHelper(filmes, nomeFilme, index + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, String nomeFilme) throws Exception {
        int left = 0;
        int right = filmes.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Filme midFilme = filmes[mid];

            int comparacao = midFilme.getNome().compareToIgnoreCase(nomeFilme);

            if (comparacao == 0) {
                return midFilme;
            } else if (comparacao < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        throw new Exception("Filme não encontrado");
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, String nomeFilme) throws Exception {
        return buscaBinariaRecursivaHelper(filmes, nomeFilme, 0, filmes.length - 1);
    }

    private Filme buscaBinariaRecursivaHelper(Filme[] filmes, String nomeFilme, int left, int right) throws Exception {
        if (left > right) {
            throw new Exception("Filme não encontrado");
        }
        int mid = left + (right - left) / 2;
        Filme midFilme = filmes[mid];

        int comparacao = midFilme.getNome().compareToIgnoreCase(nomeFilme);

        if (comparacao == 0) {
            return midFilme;
        } else if (comparacao < 0) {
            return buscaBinariaRecursivaHelper(filmes, nomeFilme, mid + 1, right);
        } else {
            return buscaBinariaRecursivaHelper(filmes, nomeFilme, left, mid - 1);
        }
    }

    @Override
    public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, String filme) throws Exception {
        return null;
    }
}
