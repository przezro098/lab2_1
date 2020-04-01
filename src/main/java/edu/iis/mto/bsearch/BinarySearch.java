/**
 *
 */
package edu.iis.mto.bsearch;

import java.util.stream.IntStream;

/**
 * Klasa dla wyszukiwania binarnego
 *
 */
public class BinarySearch {

    BinarySearch() {}

    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }

    public static boolean containsDuplicate(int[] array) {
        for (int i = 1; i < array.length; ++ i) {
            for (int j = 0; j < i; ++ j) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public SearchResult search(int key, int[] seq) {
        if(seq.length == 0) throw new IllegalArgumentException();
        if(!isSorted(seq) || containsDuplicate(seq)) throw new IllegalArgumentException();
        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }

        }
        return result;
    }

    public static BinarySearch create() {
        return new BinarySearch();
    }
}
