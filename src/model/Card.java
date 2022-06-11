package model;
public class Card
{
    private Symbols symbol;
    private Card_types type;
    
    Card(Symbols symbol, Card_types type)
    {
        this.symbol = symbol;
        this.type = type;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    public Card_types getType() {
        return type;
    }

    @Override
    public String toString() {
        return symbol + " " + type;
    }
    
}
