public class Ordenacao {
    public static Filme[] bubbleSort(Filme[] filmes) {
        Filme[] filmesClone = filmes.clone();
        int n = filmesClone.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (filmesClone[j].compareTo(filmesClone[j + 1]) > 0)
                    swap(filmesClone, i, j);
        return filmesClone;
    }
    private static void swap(Filme A[], int i, int j){
        Filme temp = A[j];
        A[j] = A[j + 1];
        A[j + 1] = temp;
    }

    public static void mergeSort(Filme[] filmesClone){
        int n = filmesClone.length;
        if (n < 2){
            return;
        }

        int midIndex = n / 2;
        Filme[] leftHalf = new Filme[midIndex];
        Filme[] rightHalf = new Filme[n - midIndex];

        for (int i = 0; i < midIndex; i++)
            leftHalf[i] = filmesClone[i];

        for (int i = midIndex; i < n; i++)
            rightHalf[i - midIndex] = filmesClone[i];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(filmesClone, leftHalf, rightHalf);
    }
    private static void merge(Filme[] filmesClone, Filme[] leftHalf, Filme[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize){
            if (leftHalf[i].compareTo(rightHalf[j]) >= 0){ //return outro < this ? -1 : (outro == this ? 0 : 1);
                filmesClone[i] = leftHalf[i];
                i++;
            }else{
                filmesClone[k] = rightHalf[j];
                j++;
            }
            k++;
            while (i < leftSize) {
                filmesClone[k] = leftHalf[i];
                i++;
                k++;
            }
            while (j < rightSize){
                filmesClone[k] = rightHalf[j];
                j++;
                k++;
            }
        }
    }
}
