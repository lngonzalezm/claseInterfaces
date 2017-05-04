package Ejemplo1;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TestPaintComponent extends JFrame{
    public TestPaintComponent() {
        add(new NewPanel());
    }
    public static void main(String[] args){
     TestPaintComponent frame= new TestPaintComponent();
     frame.setTitle("TestPaintComponent");
     frame.setSize(1000,800);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     
    }
}
class NewPanel extends JPanel implements ActionListener{
    private int x,y;
    private Timer timer;

    public NewPanel() {
        timer = new Timer(25, this);
        timer.start();
    }
    
 @Override
 protected void paintComponent (Graphics g){
     
     
     super.paintComponent(g);
     g.drawString("Puntos:xxx", 600, 100);
     g.translate(200, 200);
     //Carro1
     g.drawRect(x, y, 80, 60);
     g.drawRect(x+70, y+10, 50, 10);
     g.drawOval(x+10, y+60, 20, 20);
     g.drawOval(x+50, y+60, 20, 20);
     //Carro2
     g.drawRect(x+250, y, 80, 60);
     g.drawRect(x+250+70, y+10, 50, 10);
     g.drawOval(x+250+10, y+60, 20, 20);
     g.drawOval(x+250+50, y+60, 20, 20);
     //Objetos que caen
     g.drawRect(x+80, y-60, 10, 40);
     g.drawRect(x+120, y-60, 10, 40);
     g.drawOval(x+300, y-40, 20, 20);
     g.drawOval(x+300, y-80, 20, 20);
     //Cuadrado
     g.drawRect(x+400, y+40, 40, 40);
     g.drawString("083", (x+400), y+50);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=1;
        repaint();
    }
}
