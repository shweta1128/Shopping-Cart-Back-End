package com.techelevator;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Example1Test {

    private final Example1 sut = new Example1();

    @Test
    public void testFindMatchingIndexes() {
        assertEquals(List.of(0, 1), sut.findMatchingIndexes(List.of("foo", "bar"), new String[]{"foo", "bar"}));
        assertEquals(List.of(2), sut.findMatchingIndexes(List.of("foo", "bar", "baz", "qux"), new String[]{"boo", "far", "baz", "lux"}));
        assertEquals(List.of(), sut.findMatchingIndexes(List.of("foo", "bar"), new String[]{"bar", "foo"}));
    }

    @Test
    public void testFindCommonElements() {
        assertEquals(List.of("foo", "bar"), sut.findCommonElements(List.of("foo", "bar"), new String[]{"foo", "bar"}));
        assertEquals(List.of("baz"), sut.findCommonElements(List.of("foo", "bar", "baz", "qux"), new String[]{"boo", "far", "baz", "lux"}));
        assertEquals(List.of("foo", "bar"), sut.findCommonElements(List.of("foo", "bar"), new String[]{"bar", "foo"}));
    }

    @Test
    public void testMapAllElements() {
        assertEquals(Map.of("foo", "foo", "bar", "bar"), sut.mapAllElements(List.of("foo", "bar"), new String[]{"foo", "bar"}));
        assertEquals(Map.of("foo", "boo", "bar", "far", "baz", "baz", "qux", "lux"), sut.mapAllElements(List.of("foo", "bar", "baz", "qux"), new String[]{"boo", "far", "baz", "lux"}));
        assertEquals(Map.of("foo", "bar", "bar", "foo"), sut.mapAllElements(List.of("foo", "bar"), new String[]{"bar", "foo"}));
        assertEquals(Map.of("foo", "two"), sut.mapAllElements(List.of("foo", "foo"), new String[]{"one", "two"}));
    }
}
