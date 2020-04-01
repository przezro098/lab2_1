package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    int[] singleElementSeq = {0};
    BinarySearch binarySearch = BinarySearch.create();

    @Test
    void SearchingExistingElementInSingleSeqTest() {
        int value = 0;
        int pos = 0;
        var result = binarySearch.search(value, singleElementSeq);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(singleElementSeq[result.getPosition()], pos);
    }

}
