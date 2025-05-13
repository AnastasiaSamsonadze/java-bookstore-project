package book.tests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class UnknownGenreExceptionStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theCheckedException("book.store.UnknownGenreException")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void constructor01() {
        it.hasConstructor(withNoArgs())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void constructor02() {
        it.hasConstructor(withArgs("String"))
            .thatIs(VISIBLE_TO_ALL);
    }
}

