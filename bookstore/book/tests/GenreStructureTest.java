package book.tests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class GenreStructureTest {
    @Test
    public void testEnum() {
        CheckThat.theEnum("book.Genre")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasEnumElements("FANTASY", "ROMANTIC", "THRILLER");
    }
}

