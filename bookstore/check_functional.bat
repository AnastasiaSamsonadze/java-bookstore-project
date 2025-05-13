@ECHO OFF
set TARGET1="book/tests/BookStructureTest.java"
set TARGET2="book.tests.BookStructureTest"

set TARGET1="book/tests/CustomerStructureTest.java"
set TARGET2="book.tests.CustomerStructureTest"


set TARGET1="book/tests/GenreStructureTest.java"
set TARGET2="book.tests.GenreStructureTest"

set TARGET1="book/tests/TheWitcherStructureTest.java"
set TARGET2="book.tests.TheWitcherStructureTest"

set TARGET1="book/tests/BookStoreStructureTest.java"
set TARGET2="book.tests.BookStoreStructureTest"









if not "%~3"=="" (
    set TARGET1="%~3"
    set TARGET2="%~4"
)
@ECHO ON

javac -cp ".;junit5all.jar;checkthat.jar" %TARGET1%
java %~1 -javaagent:checkagent.jar -jar junit5all.jar execute %~2 -E junit-vintage --disable-banner -cp . -cp checkthat.jar -c %TARGET2%
