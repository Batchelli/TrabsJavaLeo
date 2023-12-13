import java.awt.*;

public class Enemy {

    public double x,y;
    public int width, height;


    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 5;
        this.height = 40;
    }
    public void tick(){
        y += (Game.ball.y - y - 6) + 1.7;
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y,width,height);
    }
}
