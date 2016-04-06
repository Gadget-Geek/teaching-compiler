import java.util.*;

class Instruction {
    String label;
    String op;
    String x;
    String y;

    public Instruction(String label, String op, String x, String y) {
        this.label = label;
        this.op = op;
        this.x = x;
        this.y = y;
    }

    public static Instruction ISTORE(int register) {
        return new Instruction("", "istore", "" + register, "");
    }

    public static Instruction IADD() {
        return new Instruction("", "iadd", "", "");
    }

    public static Instruction getPrintStream() {
        return new Instruction(
                        "", 
                        "getstatic",
                        "java/lang/System/out",
                        "Ljava/io/PrintStream");
    }
    public static Instruction invokePrintln() {
        return new Instruction(
                    "",
                    "invokevirtual",
                    "java/io/PrintStream/println(I)V",
                    "");
    }
    public static Instruction Label(String label) {
        return new Instruction(label, "nop", "", "");
    }
    public static Instruction IFZERO(String label) {
        return new Instruction("", "ifeq", label, "");
    }
    public static Instruction GOTO(String label) {
        return new Instruction("", "goto", label, "");
    }
    public static Instruction ILOAD(int reg) {
        return new Instruction("", "iload", "" + reg, "");
    }
    public static Instruction LDC(int val) {
        return new Instruction("", "ldc", "" + val, "");
    }
    public static Instruction LDC(String val) {
        return new Instruction("", "ldc", "" + val, "");
    }
    public static Instruction Op(String x) {
        String op = "iadd";
        if(x.equals("+")) op = "iadd";
        if(x.equals("-")) op = "isub";
        return new Instruction("", op, "", "");
    }
}

class Code extends Vector<Instruction> {
    static int labelCount = 0;
    public Code() {
        super();
    }

    public static Code empty() {
        return new Code();
    }
    public static String newLabel() {
        String label = "LABEL" + labelCount;
        labelCount += 1;
        return label;
    }
    @Override
    public String toString() {
        String out = "";
        for(Instruction i : this) {
            if(! i.label.equals("")) {
                out += i.label + ": ";
            }
            out += i.op + " " + i.x + " " + i.y + "\n";
        }
        return out;
    }
}
