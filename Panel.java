import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Arrays;

public class Panel extends JPanel implements ActionListener {
     static int width= 1200;
     static int height=600;
     static int unit=50;
     boolean flag=false;
     int score=0;
     Timer timer;
     Random random;
     int fx,fy;
     int length =3;

     int []xsnake = new int[288];
     int []ysnake = new int[288];
     Panel(){
          this.setPreferredSize(new Dimension(width,height));
          this.setBackground(Color.black);
          random = new Random();
          gamestart();
     }
     public void gamestart(){
          spawnfood();
          flag=true;
          timer=new Timer(160,this);
          timer.start();
     }
     public void spawnfood(){
          fx=random.nextInt(width/unit)*unit;

//          fx=random.nextInt(24)*50;
          fy=random.nextInt(height/unit)*unit;
//          fy=random.nextInt(12)*50;
     }
     public void paintComponent(Graphics graphic){
          super.paintComponent(graphic);
          draw(graphic);
     }
     public void draw(Graphics graphic){
          if(flag){
//      for food particle;
               graphic.setColor(Color.red);
               graphic.fillOval(fx,fy,50,50 );
               for(int i=0;i<length;i++){
                    graphic.setColor(Color.blue);
                    graphic.fillRect(xsnake[i],ysnake[i],50,50);
               }
               graphic.setColor(Color.cyan);
               graphic.setFont(new Font("Comic Sans",Font.BOLD,40));
               FontMetrics fme= getFontMetrics(graphic.getFont());
               graphic.drawString("Score:" + score,(width-fme.stringWidth("Score:" + score))/2,graphic.getFont().getSize());
          }
          else{
//               gameover();
          }
     }
          public void actionPerformed(ActionEvent e){


     }
}
