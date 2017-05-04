package Ejemplo1;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private int x,y;
    private Timer timer;

    public NewPanel() {
        timer = new Timer(25, this);
        this.addMouseListener(this);
        timer.start();
        
    }
    
 @Override
 protected void paintComponent (Graphics g){
     
     
     super.paintComponent(g);
     g.drawString("Puntos:xxx", 600, 100);
     g.translate(200, 200);
     //Carro1
     g.drawRect(x, y, 100, 80);
     g.drawRect(x, y, 80, 60);
     g.drawRect(x+70, y+10, 50, 10);
     g.drawOval(x+10, y+60, 20, 20);
     g.drawOval(x+50, y+60, 20, 20);
     //Carro2
     g.drawRect(x+250, y, 100, 80);
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
    public Rectangle getBounds(){
        return new Rectangle (x,y,100,80);
    }
 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x<=1000){
            x+=1;
            repaint();
        }else{
            x+=-1;
            repaint();
        }
       
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("111");
        Point mp=e.getPoint();
        if(getBounds().contains(mp)){
            timer.stop();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
