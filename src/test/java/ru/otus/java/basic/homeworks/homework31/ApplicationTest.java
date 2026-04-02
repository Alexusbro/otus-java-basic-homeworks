package ru.otus.java.basic.homeworks.homework31;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    public static Stream<Arguments> provideForTestingAfterOne() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 3}),
                Arguments.of(new int[]{2, 3, 1}, new int[]{}),
                Arguments.of(new int[]{1, 2, 1, 3}, new int[]{3})
        );
    }

    public static Stream<Arguments> provideForTestingIsArrayConsists() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, false),
                Arguments.of(new int[]{2, 2, 2}, false),
                Arguments.of(new int[]{1, 2, 2}, true),
                Arguments.of(new int[]{1, 1, 1}, false),
                Arguments.of(new int[]{1, 2, 3}, false)

        );
    }

    @MethodSource("provideForTestingAfterOne")
    @ParameterizedTest
    void arrayAfterOne(int[] array, int[] resultArray) {
        assertArrayEquals(resultArray, Application.arrayAfterOne(array));

    }

    @Test
    void arrayAfterOneException() {
        assertThrowsExactly(RuntimeException.class, () -> Application.arrayAfterOne(new int[]{2, 3, 4}));
    }

    @MethodSource("provideForTestingIsArrayConsists")
    @ParameterizedTest
    void isArrayConsistsOfOneAndTwo(int[] array, boolean result) {
        assertEquals(result, Application.isArrayConsistsOfOneAndTwo(array));

    }

}