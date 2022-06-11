package model;
public class Deck_manager
{
    private int card_num;
    private int columns;
    private Card[][] cards;
    private int shuffled = 0;
    private int shuffles_neded;

    public Deck_manager()
    {
        this(27, 3);
    }
    public Deck_manager(int card_num, int columns)
    {
        setColumns(columns);
        setCard_num(card_num);
        setCards();
    }
    
    private void setColumns(int columns)
    {
        if(columns < 3)
            this.columns = 3;
        else
        {
            if(columns % 2 == 0)
                columns++;
            this.columns = columns;
        }
    }

    private void setCard_num(int card_num)
    {
        if(card_num < columns)
            this.card_num = columns;
        else
        {
            card_num = Math.round(card_num/columns);
            if(card_num % 2 == 0)
                card_num++;
            this.card_num = card_num * columns;
        }
        //shuffles_neded
        this.shuffles_neded = 1;
        for(float card_n = this.card_num; card_n / columns > 1; card_n /= columns)
            this.shuffles_neded++;
    }

    private void setCards()
    {
        this.cards = new Card[columns][card_num/columns];
        //make posible combination arrays
        Symbols[] symbols = Symbols.values();
        Card_types[] types = Card_types.values();
        //make cards
        for(int x = 0; x < cards.length; x++)
        {
            for (int y = 0; y < cards[x].length; y++)
                cards[x][y] = new Card(symbols[((x * cards[x].length + y) / types.length) % symbols.length], types[((x * cards[x].length + y)) % types.length]);
        }
    }
    
    public void shuffle(int collumn)
    {
        //put colums to center
        Card[] chosen_column = cards[collumn];
        cards[collumn] = cards[(int)(this.columns / 2)];
        cards[(int)(this.columns / 2)] = chosen_column;
        //shuffle
        Card[][] new_cards = new Card[columns][card_num/columns];
        int column_n = 0, row_n = 0;
        for(int x = 0; x < cards.length; x++)
        {
            for (int y = 0; y < cards[x].length; y++)
            {
                new_cards[column_n][row_n] = cards[x][y];
                column_n++;
                column_n %= columns;
                if(column_n == 0)
                    row_n++;
            }
        }
        cards = new_cards;
        shuffled++;
    }
    
    public void sout_cards()
    {
        for (int y = 0; y < cards[0].length; y++)
        {
            for(int x = 0; x < cards.length; x++)
                System.out.print(cards[x][y] + "\t\t");
            System.out.println();
        }
    }

    public int getCard_num() {
        return card_num;
    }

    public int getColumns() {
        return columns;
    }

    public Card[][] getCards() {
        return cards.clone();
    }
    
    public Card getCard(int column, int row)
    {
        return cards[column][row];
    }

    public int getShuffled() {
        return shuffled;
    }

    public int getShuffles_neded() {
        return shuffles_neded;
    }

    @Override
    public String toString() {
        return "Deck_manager{" + "card_num=" + card_num + ", columns=" + columns + ", shuffled=" + shuffled + ", shuffles_neded=" + shuffles_neded + '}';
    }
    
}
