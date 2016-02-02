ANTLR = ../antlr-4.5.2-complete.jar
CP = -cp .:$(ANTLR)

all: g4 classes grun-tokens main test

g4:
	java -jar $(ANTLR) Hello.g4

classes:
	javac $(CP) Hello*.java

grun-ui:
	echo "Hello world from antlr." | java $(CP) org.antlr.v4.gui.TestRig Hello start -gui

grun-tokens:
	echo "Hello world from antlr." | java $(CP) org.antlr.v4.gui.TestRig Hello start -tokens

main:
	javac $(CP) Main.java

test:
	echo "Hello world from antlr." | java $(CP) Main
	echo "hello world from antlr." | java $(CP) Main

clean:
	rm -f Hello*.java *.class *.tokens
