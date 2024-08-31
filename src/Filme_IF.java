public interface Filme_IF extends Comparable<Filme_IF> {

    String getNome();

    void setNome(String nome);

    int getNota();

    void setNota(int nota);

    int getAno();

    void setAno(int ano);

    @Override
    int compareTo(Filme_IF outro_filme);

    @Override
    String toString();

}
