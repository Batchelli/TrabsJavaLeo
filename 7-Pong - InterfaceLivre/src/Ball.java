import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class Ball {

    public int pj = 0,pb = 0;
    public double x,y;
    public int width, height;

    public double dx, dy;
    public double speed = 2;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 4;
        this.height = 4;

        double angle = new Random().nextInt(90-20) + 90;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }
    public void tick(){
        if(y+(dy*speed) + height >= Game.HEIGHT){
            speed += 0.1;
            dy*=-1;
        }else if(y+(dy*speed) < 0){
            speed += 0.1;
            dy*=-1;
        }

        if (x >= Game.WIDTH){
            new Game();
            return;
            //ponto do inimigo
        } else if(x < 0){
            new Game();
            return;
            //ponto do jogador
        }

        Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
        Rectangle boundsEnemy = new Rectangle((int)(Game.enemy.x), (int)(Game.enemy.y), Game.enemy.width, Game.enemy.height);

        if(bounds.intersects(boundsPlayer)){
            double angle = new Random().nextInt(90-30) + 120;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));

        }else if(bounds.intersects(boundsEnemy)){

            double angle = new Random().nextInt(90 + 30) - 120;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));

        }

        x+=dx*speed;
        y+=dy*speed;
    }

    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y,width, height);
    }
}
