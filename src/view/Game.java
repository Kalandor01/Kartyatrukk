package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Deck_manager;

public class Game extends javax.swing.JFrame
{
    Deck_manager deck = new Deck_manager(21, 3);
    int rows = deck.getCard_num() / deck.getColumns();

    public Game() {
        initComponents();
        make_field();
//        System.out.println(deck);
//        deck.sout_cards();
//        System.out.println("");
//        deck.shuffle(0);
//        deck.sout_cards();
    }
    
    public void make_field()
    {
        cards_panel.removeAll();
        cards_panel.setLayout(new java.awt.GridLayout(1, deck.getColumns()));
        for (int x = 0; x < deck.getColumns(); x++)
        {
            //make column
            System.out.println("begin col");
            javax.swing.JPanel column = new javax.swing.JPanel();
            column.setLayout(new java.awt.GridLayout(2, 1));
            javax.swing.JPanel c_cards = new javax.swing.JPanel();
            c_cards.setLayout(new java.awt.GridLayout(rows, 1));
            //make cards
            System.out.println("begin card");
            for (int y = 0; y < rows; y++)
            {
                javax.swing.JPanel card = new javax.swing.JPanel();
                card.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                javax.swing.JLabel card_text = new javax.swing.JLabel();
                //set image
                try
                {
                    ImageIcon img_raw = new ImageIcon(this.getClass().getResource(deck.getCard(x, y).getImage()));
                    ImageIcon img = new ImageIcon(img_raw.getImage().getScaledInstance(120, 50, Image.SCALE_DEFAULT));
                    card_text.setIcon(img);
                } catch (Exception e)
                {
                    card_text.setText(deck.getCard(x, y).toString());
                }
                card.add(card_text);
                c_cards.add(card);
            }
            System.out.println("begin b");
            //make button
            javax.swing.JButton button = new javax.swing.JButton();
            button.setText("This column!");
            button.setToolTipText("This column!");
            int col = x;
            button.addActionListener((java.awt.event.ActionEvent evt) -> {
                choice(col);
            });
            System.out.println("end b");
            column.add(c_cards);
            column.add(button);
            cards_panel.add(column);
        }
        System.out.println("end\n\n");
        revalidate();
    }
    
    private void choice(int num)
    {
        deck.shuffle(num);
        make_field();
        if(deck.getShuffled() == deck.getShuffles_neded())
        {
            System.out.println("Win!");
            JOptionPane.showMessageDialog(this, deck.getCard((int)(deck.getColumns() / 2), (int)(rows / 2)).toString().replace("N_", " ").toLowerCase(), "You win!", JOptionPane.INFORMATION_MESSAGE);
            deck.setShuffled(0);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Kártyatrükk"); // NOI18N

        cards_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cards", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout cards_panelLayout = new javax.swing.GroupLayout(cards_panel);
        cards_panel.setLayout(cards_panelLayout);
        cards_panelLayout.setHorizontalGroup(
            cards_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        cards_panelLayout.setVerticalGroup(
            cards_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cards_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cards_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(495, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cards_panel;
    // End of variables declaration//GEN-END:variables
}
