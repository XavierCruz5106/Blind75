/*
 * This source file was generated by the Gradle 'init' task
 */
package missingnumber;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    App classUnderTest = new App();
    int[] nums = new int[]{0, 1};
    @Test void testMissingNumberSet() {
        int expected = 2;
        assertEquals(expected, classUnderTest.missingNumberSet(nums));
    }
}