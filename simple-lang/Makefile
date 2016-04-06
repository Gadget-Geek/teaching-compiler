ANTLR = ../antlr-4.5.2-complete.jar
CP = -cp .:$(ANTLR)

g4:
	java -jar $(ANTLR) -no-visitor -no-listener *.g4

classes:
	javac $(CP) *.java

test:
	java $(CP) SimpleLangParser < sample.src

clean:
	rm SimpleLang*.java *.tokens *.class
