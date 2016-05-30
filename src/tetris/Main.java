/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame implements Runnable, KeyListener {

    JLabel label[] = new JLabel[2000];
    int remem[] = new int[2000];
    int cle[] = new int[2000];
    int k = 0, l = 0, change = 1, si,si1, pos1, time,score = 0;
    boolean flag=true;
    int pos[] = new int[5];
    Thread t;
    ImageIcon b, w,green;


    Main() {
        time = 500;
        setLayout(null);
        addKeyListener(this);
        b = new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/battlefield/src/battlefield/a.png");
        w = new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/battlefield/src/battlefield/a.png");
        for (int i = 0; i < 601; i++) {
            label[i] = new JLabel();
        }

       si = (int) (Math.random() * 12);
     
        for (int i = 0; i < 520; i = i + 20) {
            for (int j = 0; j < 400; j = j + 20) {
                label[k].setBounds(j, i, 20, 20);

             //   label[k].setBorder(BorderFactory.createLineBorder(Color.black));
                add(label[k]);
                k++;

            }
        }
                label[600].setBounds(420, 0, 80, 80);
                label[600].setFont(new Font("Arial", Font.BOLD, 40));
                label[600].setText(score+"");
                label[599].setBounds(410, 50, 120, 80);
                label[599].setFont(new Font("Arial", Font.BOLD, 20));
                label[599].setText("High Score");
                label[598].setBounds(410, 150, 120, 80);
                label[598].setFont(new Font("Arial", Font.BOLD, 20));
                
                add(label[600]);
                add(label[599]);
                add(label[598]);
        for (int i = 0; i <= 500; i = i + 20) {
            remem[i] = 1;
          //  label[i].setIcon(b);
        }

        for (int i = 500; i <= 519; i++) {
            remem[i] = 1;
            //label[i].setIcon(b);
        }

        for (int i = 19; i <= 519; i = i + 20) {
            remem[i] = 1;
           // label[i].setIcon(b);
        }
        
       
        setSize(600, 600);
     
        t = new Thread(this);
        t.start();

    }

    public void run() {
        choose();
        while (true) {
            draw();
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
            }
            
             for (int i = 0; i <= 500; i = i + 20) {
            remem[i] = 1;
          //  label[i].setIcon(b);
        }

        for (int i = 500; i <= 519; i++) {
            remem[i] = 1;
            //label[i].setIcon(b);
        }

        for (int i = 19; i <= 519; i = i + 20) {
            remem[i] = 1;
           // label[i].setIcon(b);
        }
        
            clear();
             check();
        }
    }
    public void check()
    {
        for(int i=2;i<19;i++)
        {
            if(remem[i]==1)
            {
                System.out.println("Game Over");
                JOptionPane.showMessageDialog(this, "Game Over");
                System.exit(1);
            }
        }
    }
    public void draw() {
        if (remem[l + pos[0] + 20] == 0 && remem[l + pos[1] + 20] == 0 && remem[pos[2] + l + 20] == 0 && remem[pos[3] + l + 20] == 0) {
            label[pos[0] + l].setIcon(b);
            label[pos[1] + l].setIcon(b);
            label[pos[2] + l].setIcon(b);
            label[pos[3] + l].setIcon(b);
         
            l += 20;

        } else {
            remem[l + pos[0]] = 1;
            remem[l + pos[1]] = 1;
            remem[l + pos[2]] = 1;
            remem[l + pos[3]] = 1;
            l = 0;
            choose();
        }

    }

    public void clear() {
        for (int i = 0; i < 598; i++) {
          
            if (remem[i] == 0) {
                
                label[i].setIcon(null);
            } else {
                label[i].setIcon(b);
            }
        }

        for (int i = 499; i >= 20; i -= 20) {
           

            if (remem[i - 1] == 0 && remem[i - 2] == 0 && remem[i - 3] == 0 && remem[i - 4] == 0 && remem[i - 5] == 0 && remem[i - 6] == 0 && remem[i - 7] == 0 && remem[i - 8] == 0 && remem[i - 9] == 0 && remem[i - 10] == 0 && remem[i - 11] == 0 && remem[i - 12] == 0 && remem[i - 13] == 0 && remem[i - 14] == 0 && remem[i - 15] == 0 && remem[i - 16] == 0 && remem[i - 17] == 0 && remem[i - 18] == 0 ) {
                for (int j = i; j >= i - 19; j--) {
                    remem[j] = remem[j - 20];
                    remem[j - 20] = 0;
                }

            }

        }

        for (int i = 499; i >= 0; i -= 20) {
            

            if (remem[i] == 1 && remem[i - 1] == 1 && remem[i - 2] == 1 && remem[i - 3] == 1 && remem[i - 4] == 1 && remem[i - 5] == 1 && remem[i - 6] == 1 && remem[i - 7] == 1 && remem[i - 8] == 1 && remem[i - 9] == 1 && remem[i - 10] == 1 && remem[i - 11] == 1 && remem[i - 12] == 1 && remem[i - 13] == 1 && remem[i - 14] == 1 && remem[i - 15] == 1 && remem[i - 16] == 1 && remem[i - 17] == 1 && remem[i - 18] == 1 && remem[i - 19] == 1) {
                for (int j = i; j >= i - 19; j--) {
                    remem[j] = 0;

                }
                score+=10;
                label[600].setText(score+"");

            }
        }

    }

    public static void main(String[] args) {
        Main ob = new Main();
        //Thread t2=new Thread(this);
        //t2.start();

        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setVisible(true);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyText(e.getKeyCode()) == "Down") {
            time = 100;
        }
    }

    public void choose() {
        System.out.println(""+si);
       

        choosed(si);
         si = (int) (Math.random() * 12);
        
        switch(si)
        {
            case 0:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/0.png"));
                break;
            case 1:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/1.png"));
                break;
            case 2:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/2.png"));
                break;
            case 3:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/3.png"));
                break;
            case 4:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/4.png"));
                break;
            case 5:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/5.png"));
                break;
            case 6:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/6.png"));
                break;
            case 7:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/7.png"));
                break;
            case 8:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/8.png"));
                break;
            case 9:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/9.png"));
                break;
            case 10:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/10.png"));
                break;
            case 11:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/11.png"));
                break;
            case 12:
                label[598].setIcon(new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/Tetris/src/tetris/12.png"));
                break;

        }
       
        System.out.println(""+si);
        

        
        
        pos1 = 0;
    }

    public void choosed(int si) {
        switch (si) {
            case 0:
                pos[0] = 5;                     //  |
                pos[1] = 25;                    //  |
                pos[2] = 45;                    //  |___
                pos[3] = 46;                    //
                change=1;
                
                si1=0;
                break;
            case 1:
                pos[0] = 5;                     //   |
                pos[1] = 25;                    //   |
                pos[2] = 45;                    //   |
                pos[3] = 65;                    //   |
                si1=1;
                
                change=1;
                break;
            case 2:
                pos[0] = 5;                     //  |
                pos[1] = 25;                    //  |----
                pos[2] = 45;                    //  |
                pos[3] = 26;
             
                si1=2;
                change =1;//
                break;
            case 3:
                pos[0] = 5;                     //
                pos[1] = 6;                     //  -- --
                pos[2] = 25;                    //  -- --
                pos[3] = 26;                    //
                si1=3;
               
                change=1;
                break;
            case 4:
                pos[0] = 5;                     //
                pos[1] = 6;                     // _____
                pos[2] = 26;                    //    |_____
                pos[3] = 27;                    //
                si1=4;
               
                change=1;
                break;
            case 5:
                pos[0] = 45;                    //
                pos[1] = 46;                    //        |
                pos[2] = 47;                    //  -------
                pos[3] = 27;                    //
                si1=0;
                
                change=2;
                break;
            case 6:
                pos[0] = 47;                    //
                pos[1] = 27;                    //   - -|
                pos[2] = 7;                     //      |
                pos[3] = 6;                     //      |
                si1=0;
                change=3;
             
                break;
            case 7:
                pos[0] = 7;                     //
                pos[1] = 6;                     //  |--------
                pos[2] = 5;                     //  |
                pos[3] = 25;                    //
                si1=0;
                change=0;
             
                break;
             case 8:
                pos[0] = 23;                     //
                pos[1] = 24;                     //
                pos[2] = 25;                    //  -----------
                pos[3] = 26;                    //
                si1=1;
                change=0;

                break;
             case 9:
                pos[0] = 25;                     //      |
                pos[1] = 26;                     //      |
                pos[2] = 27;                    // - - - - - - -
                pos[3] = 6;                    //
                si1=2;
                change=2;
    
                break;
            case 10:
                pos[0] = 7;                     //       |
                pos[1] = 27;                     //  ----|
                pos[2] = 47;                    //       |
                pos[3] = 26;                    //
                si1=2;
                change=3;
               
                break;
            case 11:
                pos[0] = 5;                     //
                pos[1] = 6;                     //  ---------
                pos[2] = 7;                    //       |
                pos[3] = 26;                    //      |
                si1=2;
                change=0;
             
                break;

            case 12:                            //      |
                pos[0] = 46;                    //      |
                pos[1] = 26;                    //  -----
                pos[2] = 27;                    //  |
                pos[3] = 7;                    //   |
                si1=4;
                change=0;
             
                break;

        }
      
    }

    public void keyReleased(KeyEvent e) {

//        switch(e.getKeyCode()){
//            case 40:
//                break;
//            case 39:
//                break;
//            case 38:
//                break;
//            case 41:
//                break;
//        }
        String str = e.getKeyText(e.getKeyCode());
        if (str.equals("Down")) {
            time = 500;
        }


        if (e.getKeyCode() == 32) {

            switch (si1) {

                case 0:
                    switch (change) {
                        case 0:
                            if (remem[l + pos[0] - 2] == 0 && remem[l + pos[1] + 19] == 0 && remem[l + pos[2] + 40] == 0 && remem[l + pos[3] + 21] == 0) {
                                pos[0] += -2;
                                pos[1] += 19;
                                pos[2] += 40;
                                pos[3] += 21;          //       |
                                change = 1;           //        |
                                //                              |___
                            }
                            break;
                        case 1:
                            if (remem[l + pos[0] + 40] == 0 && remem[l + pos[1] + 21] == 0 && remem[l + pos[2] + 2] == 0 && remem[l + pos[3] - 19] == 0) {
                                pos[0] += 40;            //5
                                pos[1] += 21;          //25
                                pos[2] += 2;          //45  ____|
                                pos[3] += -19;          //46
                                change = 2;

                            }
                            break;
                        case 2:
                            if (remem[l + pos[0] + 2] == 0 && remem[l + pos[1] - 19] == 0 && remem[l + pos[2] - 40] == 0 && remem[l + pos[3] - 21] == 0) {
                                pos[0] += 2;         //40
                                pos[1] += -19;          // 25 -|
                                pos[2] += -40;           //45 |
                                pos[3] += -21;           // 46|
                                change = 3;

                            }
                            break;
                        case 3:
                            if (remem[l + pos[0] - 40] == 0 && remem[l + pos[1] - 21] == 0 && remem[l + pos[2] - 2] == 0 && remem[l + pos[3] + 19] == 0) {
                                pos[0] += -40;
                                pos[1] += -21;           //   ___
                                pos[2] += -2;           //  |
                                pos[3] += 19;         //
                                change = 0;

                            }
                            break;
                    }
                    //  change=0;
                    break;
                case 1:
                    switch (change) {

                        case 1:
                            if (remem[l + pos[0] + 18] == 0 && remem[l + pos[1] - 1] == 0 && remem[l + pos[2] - 20] == 0 && remem[l + pos[3] - 39] == 0) {
                                pos[0] += 18;               //   |
                                pos[1] += -1;              //   |
                                pos[2] += -20;              //   |
                                pos[3] += -39;             //    |
                                change = 0;

                            }
                            break;
                        case 0:
                            if (remem[l - 1 + pos[0] - 18] == 0 && remem[l - 1 + pos[1] + 1] == 0 && remem[l - 1 + pos[2] + 20] == 0 && remem[l - 1 + pos[3] + 39] == 0) {
                                pos[0] += -18;
                                pos[1] += +1;
                                pos[2] += 20;   ///  - - - -
                                pos[3] += 39;
                                change = 1;

                            }
                            break;
                    }
                    //         change=0;
                    break;
                case 2:
                    switch (change) {

                        case 1:
                            if (remem[l + 40 + pos[0]] == 0 && remem[l + 21 + pos[1]] == 0 && remem[l + 2 + pos[2]] == 0 && remem[l + pos[3]] == 0) {
                                pos[0] += 40;
                                pos[1] += 21;          // |
                                pos[2] += 2;           // |--
                                change = 2;

                            }
                            break;
                        case 2:
                            if (remem[l - 38 + pos[0]] == 0 && remem[l - 19 + pos[1]] == 0 && remem[l + pos[2]] == 0 && remem[l + pos[3]] == 0) {
                                pos[0] += -38;                  //  |
                                pos[1] += -19;                  //- - -
                                change = 3;

                            }
                            break;
                        case 3:
                            if (remem[l - 2 + pos[0]] == 0 && remem[l - 21 + pos[1]] == 0 && remem[l - 40 + pos[2]] == 0 && remem[l + pos[3]] == 0) {
                                pos[0] += -2;                  //
                                pos[1] += -21;                  //    |
                                pos[2] += -40;                   //  -|
                                //    |
                                change = 0;

                            }
                            break;

                        case 0:
                            if (remem[l + pos[0]] == 0 && remem[l + 19 + pos[1]] == 0 && remem[l + 38 + pos[2]] == 0 && remem[l + pos[3]] == 0) {
                                pos[0] += 0;
                                pos[1] += 19;       //      - - -
                                pos[2] += 38;       //        |
                                //
                                change = 1;

                            }
                            break;
                    }
                    //       change=0;
                    break;

                case 3:
                    switch (change) {

                        case 0:
                            if (remem[l - 20 + pos[0]] == 0 && remem[l - 20 + pos[1]] == 0 && remem[l + 20 + pos[2]] == 0 && remem[l + 20 + pos[3]] == 0) {
                                pos[0] += -20;    //    ||
                                pos[1] += -20;    //    ||
                                pos[2] += +20;
                                pos[3] += +20;
                            }
                            change = 1;
                            break;
                        case 1:
                            if (remem[l + 20 + pos[0]] == 0 && remem[l + 20 + pos[1]] == 0 && remem[l - 20 + pos[2]] == 0 && remem[l - 20 + pos[3]] == 0) {
                                pos[0] += 20;    //    ||
                                pos[1] += 20;    //    ||
                                pos[2] += -20;
                                pos[3] += -20;
                                change = 0;
                            }
                            break;
                    }
                    break;
                case 4:
                    switch (change) {
                        case 0:
                            if (remem[l + pos[0] - 41] == 0 && remem[l + pos[1] - 20] == 0 && remem[l + pos[2] - 1] == 0 && remem[l + pos[3] + 20] == 0) {
                                pos[0] -= 41;
                                pos[1] -= 20;
                                pos[2] -= 1;            //
                                pos[3] += 20;          //     --
                                change = 1;           //        |
                                //      |___                     __
                            }
                            break;
                        case 1:
                            if (remem[l + pos[0] + 41] == 0 && remem[l + pos[1] + 20] == 0 && remem[l + pos[2] + 1] == 0 && remem[l + pos[3] - 20] == 0) {
                                pos[0] += 41;            //5
                                pos[1] += 20;          //25  _|
                                pos[2] += 1;          //45  |
                                pos[3] += -20;          //46
                                change = 0;

                            }
                            break;
                    }
                    //  change=0;
                    break;
            }
        }
        if (e.getKeyCode() == 37) {
            if (remem[l - 1 + pos[0]] == 0 && remem[l - 1 + pos[1]] == 0 && remem[l - 1 + pos[2]] == 0 && remem[l - 1 + pos[3]] == 0) {


                pos[0] -= 1;
                pos[1] -= 1;
                pos[2] -= 1;
                pos[3] -= 1;
                pos1 -= 1;


            }
        } else if (e.getKeyCode() == 39) {
            if (remem[l + 1 + pos[0]] == 0 && remem[l + 1 + pos[1]] == 0 && remem[l + 1 + pos[2]] == 0 && remem[l + 1 + pos[3]] == 0) {

                pos[0] += 1;
                pos[1] += 1;
                pos[2] += 1;
                pos[3] += 1;
                pos1 += 1;
            }

        }



    }
}
