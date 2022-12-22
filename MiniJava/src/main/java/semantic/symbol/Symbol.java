package semantic.symbol;

/**
 * Created by mohammad hosein on 6/28/2015.
 */
public class Symbol{
    public SymbolType type;
    public int address;
    public Symbol(SymbolType type , int address)
    {
        this.type = type;
        this.address = address;
    }
}
