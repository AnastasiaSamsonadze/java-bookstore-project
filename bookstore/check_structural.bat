:: These tests check the names/types of
:: packages/classes/constructors/methods/parameters.
:: They do not check how the code works.
:: They do even refer to the code directly.

@ECHO OFF
set PROPS=%~1
set OPTS=%~2

set TARGET1="book/tests/BookStoreStructureTest.java"
set TARGET2="book.tests.BookStoreStructureTest"

set TARGET1="book/tests/BookStructureTest.java"
set TARGET2="book.tests.BookStructureTest"



set TARGET1="book/tests/CustomerStructureTest.java"
set TARGET2="book.tests.CustomerStructureTest"

set TARGET1="book/tests/GenreStructureTest.java"
set TARGET2="book.tests.GenreStructureTest"



set TARGET1="book/tests/TheWitcherStructureTest.java"
set TARGET2="book.tests.TheWitcherStructureTest"







if not "%~3"=="" (
    set TARGET1="%~3"
    set TARGET2="%~4"
)
@ECHO ON

:: Compile the tested classes separately
:: if you use the structural tests but not the full suite.
:: Like this but without the comment:

: javac time\Time.java

javac -cp ".;junit5all.jar;checkthat.jar" %TARGET1%
java %PROPS% -javaagent:checkagent.jar -jar junit5all.jar execute %OPTS% -E junit-vintage --disable-banner -cp . -cp checkthat.jar -c %TARGET2%
