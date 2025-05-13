package book.tests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class TheWitcherStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("book.TheWitcher", withParent("book.Book"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatHas(TEXTUAL_REPRESENTATION);
    }

    @Test
    @DisabledIf(notApplicable)
    public void fieldSubtitle() {
        it.hasField("subtitle: String")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    @DisabledIf(notApplicable)
    public void constructor() {
        it.hasConstructor(withArgs("genre: Genre", "numberOfPages: int", "price: int", "ageLimit: int", "subtitle: String"))
            .thatIs(VISIBLE_TO_ALL);
    }
}

