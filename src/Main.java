import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String RESET = "\033[0m";  // Reseta para a cor padrão
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

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
        System.out.println(GREEN + "Array original" + RESET);
        for (Filme f : filmes){
            System.out.println(GREEN + f + RESET);
        }
        System.out.println();

        //BubbleSort
        Filme[] filmesCloneBuble = filmes.clone();
        Ordenacao ordenacao = new Ordenacao();
        ordenacao.bubbleSort(filmesCloneBuble);
        System.out.println(BLUE + "BubleSort" + RESET);
        for (Filme f : filmesCloneBuble){
            System.out.println(BLUE + f + RESET);
        }

        //MergeSort
        System.out.println();
        Filme[] filmesMerge = filmes.clone();
        ordenacao.mergeSort(filmesMerge);
        System.out.println(PURPLE + "MergeSort" + RESET);
        for (Filme f : filmesMerge){
            System.out.println(PURPLE + f + RESET);
        }

        //QuickSort
        System.out.println();
        Filme[] filmesQuick = filmes.clone();
        ordenacao.quickSort(filmesQuick, 0, filmesQuick.length - 1);
        System.out.println(YELLOW + "QuickSort" + RESET);
        for (Filme f : filmesQuick){
            System.out.println(YELLOW + f + RESET);
        }

        //QuickSortRandom
        System.out.println();
        List<Filme> filmesQuickRandom = new ArrayList<>();
        for (Filme f : filmes){
            filmesQuickRandom.add(f);
        }
        ordenacao.quickSortRandom(filmesQuickRandom, 0, filmesQuickRandom.size() - 1);
        System.out.println(CYAN + "QuickSortRandom" + RESET);
        for (Filme f : filmesQuick){
            System.out.println(CYAN + f + RESET);
        }

        //CountingSort
        System.out.println();
        Filme[] filmesCounting = filmes.clone();
        ordenacao.countingSort(filmesCounting, 10);
        System.out.println(WHITE + "CountingSort" + RESET);
        for (Filme f : filmesCounting){
            System.out.println(WHITE + f + RESET);
        }
    }
}