import java.util.*;
import org.antlr.v4.runtime.*;

class Main {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        SimpleLexer lexer = new SimpleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(tokens);
        parser.start();

    }
}

class SymbolTable extends TreeMap<String, Integer> {
    int resolve(String name, boolean create) {
        int reg = -1;
        if(this.containsKey(name)) {
            reg = this.get(name);
        } else {
            if(create) {
                reg = this.size();
                this.put(name, reg);
            }
        }
        return reg;
    }
}

class Code extends Vector<String> {
    public static int labelCounter = 0;
    public static String newLabel() {
        labelCounter += 1;
        return "label_" + labelCounter;
    }

    public Code() {
        super();
    }

    public Code append(String i) {
        this.add(i);
        return this;
    }

    public Code extend(Code more) {
        this.addAll(more);
        return this;
    }
}

class I {
    public static String ISTORE(int r) {
        return "istore " + r;
    }

    public static String GetPrintStream() {
        return "getstatic java/lang/System/out Ljava/io/PrintStream;";
    }

    public static String invokePrintln() {
        return "invokevirtual java/io/PrintStream/println(I)V";
    }

    public static String Label(String label) {
        return label + ":";
    }

    public static String IFZERO(String label) {
        return "ifeq " + label;
    }

    public static String IFGE(String label) {
        return "ifge " + label;
    }


    public static String GOTO(String label) {
        return "goto " + label;
    }

    public static String LDC(int v) {
        return "ldc " + v;
    }
    public static String LDC(String v) {
        return "ldc " + v;
    }

    public static String ILOAD(int r) {
        return "iload " + r;
    }

    public static String IADD() {
        return "iadd";
    }

    public static String ISUB() {
        return "isub";
    }

    public static String Op(String op) {
        if(op.equals("+"))
            return IADD();
        else if(op.equals("-"))
            return ISUB();
        else
            return IADD();
    }
}
