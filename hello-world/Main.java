import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ANTLRInputStream input = new ANTLRInputStream(System.in);

        HelloLexer lexer = new HelloLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        HelloParser parser = new HelloParser(tokens);

        parser.start();
        
        System.out.println("The end.");
    }
}
