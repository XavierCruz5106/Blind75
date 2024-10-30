/*
 * This source file was generated by the Gradle 'init' task
 */
package productofarrayexceptself;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    int[] nums = new int[]{1, 2, 3, 4};
    int[] expected = new int[]{24,12,8,6};
    App classToTest = new App();

    @Test void solution1ReturnsProperArray(){
        assertArrayEquals(expected, classToTest.solution1(nums));
    }

    @Test void solution2ReturnsProperArray(){

        assertArrayEquals(expected, classToTest.solution2(nums));
    }

    @Test void solution3ReturnProperArray(){
        assertArrayEquals(expected, classToTest.solution3(nums));
    }
}
