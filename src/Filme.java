public class Filme implements Filme_IF{
    private String nome;
    private int nota;
    private int ano;

    public Filme(){}

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }

    @Override
    public int compareTo(Filme_IF outroFilme) {
        // Primeiro critério: Nota (decrescente) return x < y ? -1 : (x == y ? 0 : 1);
        int notaComparacao = Integer.compare(outroFilme.getNota(), this.nota);
        if (notaComparacao != 0) {
            return notaComparacao;
        }
        // Segundo critério: Ano (crescente)
        int anoComparacao = Integer.compare(this.ano, outroFilme.getAno());
        if (anoComparacao != 0) {
            return anoComparacao;
        }
        // Terceiro critério: Nome (crescente)
        return this.nome.compareTo(outroFilme.getNome());
    }
}
