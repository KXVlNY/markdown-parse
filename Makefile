test: MarkdownParse.java
	javac MarkdownParse.java

test2: MarkdownParseTest.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
