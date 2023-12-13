import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int ESCALE = 4;

    public BufferedImage layer = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static Player player;
    public static Enemy enemy;
    public static Ball ball;
    public static Placar placar;

    public Game(){
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH*ESCALE, HEIGHT*ESCALE));
        player = new Player(WIDTH-5,HEIGHT/3);
        enemy = new Enemy(0 , HEIGHT/3);
        ball = new Ball(100,HEIGHT/3);
        placar = new Placar(95, 0);
    }

    public static void main(String[] args){
        Game game = new Game();
        JFrame frame = new JFrame("Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();

        new Thread(game).start();
    }

    public void tick(){
        player.tick();
        enemy.tick();
        ball.tick();
        placar.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        player.render(g);
        enemy.render(g);
        ball.render(g);
//        placar.render(g);

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0 , 0, WIDTH*ESCALE, HEIGHT*ESCALE,null);
        bs.show();
    }


    @Override
    public void run() {
        while(true){
            tick();
            render();
            try{
                Thread.sleep(1000/60);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            player.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            player.down = false;
        }
    }
}
