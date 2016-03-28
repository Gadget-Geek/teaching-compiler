ANTLR = ../antlr-4.5.2-complete.jar
CP = -cp .:$(ANTLR)
.PHONY: g4 classes clean

g4:
	java -jar $(ANTLR) -no-visitor -no-listener Action.g4

classes: g4
	javac $(CP) *.java

run:
	java $(CP) Main

clean:
	rm -f *.class *.tokens Action*.java
