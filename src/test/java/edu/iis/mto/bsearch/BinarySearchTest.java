package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    int[] singleElementSeq = {0};
    int[] MultiElementSeq = {0,1,2,3,4};
    int pos = 0;
    int value = 0;
    BinarySearch binarySearch = BinarySearch.create();

    @Test
    void SearchingExistingElementInSingleSeq() {
        value = 0;
        pos = 0;
        var result = binarySearch.search(value, singleElementSeq);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(singleElementSeq[result.getPosition()], pos);
    }

    @Test
    void SearchingNoneExistingElementInSingleSeq() {
        value = 1;
        pos = -1;
        var result = binarySearch.search(value, singleElementSeq);
        Assertions.assertFalse(result.isFound());
        Assertions.assertEquals(result.getPosition(), pos);
    }

    @Test
    void SearchingFirstElementInMultiSeq() {
        value = 0;
        pos = 0;
        var result = binarySearch.search(value, MultiElementSeq);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(result.getPosition(), pos);
    }

    @Test
    void SearchingLastElementInMultiSeq() {
        value = 4;
        pos = 4;
        var result = binarySearch.search(value, MultiElementSeq);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(result.getPosition(), pos);
    }

    @Test
    void SearchingCentralElementInMultiSeq() {
        value = 2;
        pos = 2;
        var result = binarySearch.search(value, MultiElementSeq);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(result.getPosition(), pos);
    }

    @Test
    void SearchingNoneExistingElementInMultiSeq() {
        value = 5;
        pos = -1;
        var result = binarySearch.search(value, MultiElementSeq);
        Assertions.assertFalse(result.isFound());
        Assertions.assertEquals(result.getPosition(), pos);
    }




}
