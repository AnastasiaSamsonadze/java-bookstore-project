package book.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({
      BookStoreTestSuite.StructuralTests.class
//    , BookStoreTestSuite.FunctionalTests.class
})
@Suite public class BookStoreTestSuite {
	@SelectClasses({
	      BookStructureTest.class
        , GenreStructureTest.class
        , TheWitcherStructureTest.class
        , BookStoreStructureTest.class
        , UnknownGenreExceptionStructureTest.class
        , CustomerStructureTest.class
        , InsufficientBalanceExceptionStructureTest.class
	})
	@Suite public static class StructuralTests {}

//	@SelectClasses({
//          BookStoreTest.class
//	})
//	@Suite public static class FunctionalTests {}
}

