package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class BinarySearchTest {

    int[] emptySeq = {};
    int[] singleElementSeq = {0};
    int[] multiElementSeq = {0,1,2,3,4};
    int[] sameElementSeq = {0,0,0,0,0};
    int[] descOrderSeq = {4,3,2,1};
    BinarySearch binarySearch = BinarySearch.create();

    @Test
    void SearchingExistingElementInSingleSeq() {
        var result = binarySearch.search(0, singleElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(0));
    }

    @Test
    void SearchingNoneExistingElementInSingleSeq() {
        var result = binarySearch.search(1, singleElementSeq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @Test
    void SearchingFirstElementInMultiSeq() {
        var result = binarySearch.search(0, multiElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(0));
    }

    @Test
    void SearchingLastElementInMultiSeq() {
        var result = binarySearch.search(4, multiElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(4));
    }

    @Test
    void SearchingCentralElementInMultiSeq() {
        var result = binarySearch.search(2, multiElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(2));
    }

    @Test
    void SearchingNoneExistingElementInMultiSeq() {
        var result = binarySearch.search(5, multiElementSeq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @Test
    void SearchingInEmptySeq() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(0, emptySeq));
    }

    @Test
    void SearchingInSameElementSeq() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(0, sameElementSeq));
    }

    @Test
    void SearchingInDescOrderSeq() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(0, descOrderSeq));
    }




}
