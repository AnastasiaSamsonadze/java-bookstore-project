package book.tests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class BookStoreStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("book.store.BookStore")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void fieldShelf() {
        it.hasField("shelf: ArrayList of Book")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER)
            .withInitialValue("empty list");
    }

    @Test
    @DisabledIf(notApplicable)
    public void constructor() {
        it.hasConstructor(withArgs("filename: String"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodPurchased() {
        it.hasMethod("purchased", withParams("book: book.Book"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodShipmentArrived() {
        it.hasMethod("shipmentArrived", withParams("ArrayList of Book"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}

