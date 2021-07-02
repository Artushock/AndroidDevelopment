package java_core_for_android.lesson14_development_tools_overview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*@author Artiom Ponomariov*/
class DevToolsMainTest {
    DevToolsMain devToolsMain;

    @BeforeEach
    void init() {
        devToolsMain = new DevToolsMain();
    }

    @DisplayName("Проверка getAfterLastFour() на выбрасывание исключения. ")
    @Test
    void getAfterLastFour() {
        Assertions.assertThrows(RuntimeException.class, () ->
            devToolsMain.getAfterLastFour(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 0})
        );
    }

    @DisplayName("Проверка getAfterLastFour() с разлиными аргкментами. ")
    @ParameterizedTest
    @MethodSource("argsGetAfterLastFour")
    void getAfterLastFour(int[] expected, int[] given) {
        Assertions.assertArrayEquals(expected, devToolsMain.getAfterLastFour(given));
    }

    @DisplayName("Проверка findOneAndFour(arr) с разлиными аргкментами. ")
    @ParameterizedTest
    @MethodSource("argsFindOneAndFour")
    void findOneAndFour(boolean expected, int[] arr) {
        Assertions.assertEquals(expected, devToolsMain.findOneAndFour(arr));
    }

    static Stream<Arguments> argsFindOneAndFour() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1, 1, 1, 4, 4, 1, 4, 4}),
                Arguments.arguments(false, new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.arguments(false, new int[]{4, 4, 4, 4}),
                Arguments.arguments(false, new int[]{1, 4, 4, 1, 1, 4, 3}),
                Arguments.arguments(false, new int[]{2, 3, 5, 6})
        );
    }

    static Stream<Arguments> argsGetAfterLastFour() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{1, 7}, new int[]{4, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{1, 7, 1, 7, 1, 7}, new int[]{4, 1, 7, 1, 7, 1, 7}),
                Arguments.arguments(new int[]{}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 4})
        );
    }
}