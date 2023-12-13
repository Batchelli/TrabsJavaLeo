import java.awt.*;

public class Player {

    public boolean up , down;
    public int x,y;
    public int width, height;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 5;
        this.height = 40;
    }
    public void tick(){
//        y += (Game.ball.y - y - 6);
        if(up){
            y++;
        } else if(down){
            y--;
        }

        if(y+height > Game.HEIGHT){
        y = Game.HEIGHT - height;
        } else if(y < 0){
            y = 0;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y,width,height);
    }
}
