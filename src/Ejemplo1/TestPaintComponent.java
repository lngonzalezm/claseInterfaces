package Ejemplo1;


import java.awt.*;
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
     frame.setSize(1024,512);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     
    }
}
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private int x,y;
    private Timer timer;
    private int secuencia;

    public NewPanel() {
        timer = new Timer(25, this);
        this.addMouseListener(this);
        timer.start();
        this.secuencia = 0;
    }
    
 @Override
 protected void paintComponent (Graphics g){
     
     super.paintComponent(g);
     Image fondo = loadImage("fondo.png");
     g.drawImage(fondo, 0,0, null);
     Image gato = loadImage("cats.gif");
     Image a= loadImage("free_radical_game_sprites.png");
     Image moneda = loadImage("FullCoins.png");
     g.translate(200, 350);
     g.drawImage(a, x, y,x+32,y+32,192+(this.secuencia*32),192,(this.secuencia*32)+192+32,192+32,this);
     g.drawImage(moneda,16,16,16, 16,16,0,16+16,16,this);
     g.drawString("Puntos:xxx", 600, 100);
    
     //Carro1
     g.drawRect(x, y, 132, 80);
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
     g.drawRect(400, 40, 40, 40);
     g.drawString("083", 400, 50);
    }
    public Rectangle getBounds(){
        return new Rectangle (x,y,135,80);
    }
    public void DetectarColision (){
        Rectangle tanque= getBounds();
        Rectangle objeto = new Rectangle (400, 40, 40, 40);
        if (tanque.intersects(objeto)){
           // System.out.println("22");
            timer.stop();
        }
    }
 public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=1;
        if(this.secuencia == 2){
          this.secuencia = 0;
        }else 
            this.secuencia++;
        
        DetectarColision ();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("111");
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