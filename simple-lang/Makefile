ANTLR = ../antlr-4.5.2-complete.jar
CP = -cp .:$(ANTLR)

all : g4 classes test

g4:
	java -jar $(ANTLR) -no-visitor -no-listener *.g4

classes:
	javac $(CP) *.java

test:
	java $(CP) Main < sample.src > sample.j
	java -jar jasmin.jar sample.j
	java -cp . MyApp

clean:
	rm -f Simple*.java *.tokens *.class *.j
