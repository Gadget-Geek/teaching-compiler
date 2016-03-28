import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ANTLRInputStream input = new ANTLRFileStream("./test.txt");

        ActionLexer lexer = new ActionLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ActionParser parser = new ActionParser(tokens);

        parser.start();
    }
}
