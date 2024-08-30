public class Main {
    public static void main(String[] args) {
        Filme f1 = new Filme("A", 10, 1983);
        Filme f2 = new Filme("B", 1, 1982);
        Filme f3 = new Filme("C", 5, 1973);
        Filme f4 = new Filme("D", 9, 1981);
        Filme f5 = new Filme("E", 3, 1982);
        Filme f6 = new Filme("F", 4, 1986);
        Filme f7 = new Filme("G", 8, 2000);
        Filme f8 = new Filme("H", 2, 2010);
        Filme f9 = new Filme("I", 7, 1960);
        Filme f10 = new Filme("J", 6, 2023);

        Filme[] filmes = {f1, f2, f3, f4, f5, f6, f7, f8, f9, f10};
        for (Filme f : filmes){
            System.out.println(f);
        }
        System.out.println();

        //BubbleSort
        Filme[] filmesCloneBuble = filmes.clone();
        Ordenacao ordenacao = new Ordenacao();
        ordenacao.bubbleSort(filmesCloneBuble);
        for (Filme f : filmesCloneBuble){
            System.out.println(f);
        }

        //mergeSort
        System.out.println();
        Filme[] filmesMerge = filmes.clone();
        ordenacao.mergeSort(filmesMerge);
        for (Filme f : filmesMerge){
            System.out.println(f);
        }

        //quickSort
        System.out.println();
        Filme[] filmesQuick = filmes.clone();
        ordenacao.quickSort(filmesQuick, 0, filmesQuick.length - 1);
        for (Filme f : filmesQuick){
            System.out.println(f);
        }
    }
}