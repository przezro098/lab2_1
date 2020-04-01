package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class BinarySearchTest {

    int[] emptySeq = {};
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
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(pos));
    }

    @Test
    void SearchingNoneExistingElementInSingleSeq() {
        value = 1;
        pos = -1;
        var result = binarySearch.search(value, singleElementSeq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(pos));
    }

    @Test
    void SearchingFirstElementInMultiSeq() {
        value = 0;
        pos = 0;
        var result = binarySearch.search(value, MultiElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(pos));
    }

    @Test
    void SearchingLastElementInMultiSeq() {
        value = 4;
        pos = 4;
        var result = binarySearch.search(value, MultiElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(pos));
    }

    @Test
    void SearchingCentralElementInMultiSeq() {
        value = 2;
        pos = 2;
        var result = binarySearch.search(value, MultiElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(pos));
    }

    @Test
    void SearchingNoneExistingElementInMultiSeq() {
        value = 5;
        pos = -1;
        var result = binarySearch.search(value, MultiElementSeq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(pos));
    }

    @Test
    void SearchingInEmptySeq() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(0, emptySeq));
    }




}
