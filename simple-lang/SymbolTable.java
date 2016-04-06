import java.util.*;

public class SymbolTable extends TreeMap<String, Integer> {
    static int registerCount = 0;

    public SymbolTable() {
        super();
    }

    public int resolve(String varname) {
        if(! this.containsKey(varname)) {
            int register = SymbolTable.registerCount;
            SymbolTable.registerCount += 1;
            this.put(varname, register);
        }

        return this.get(varname);
    }
}
