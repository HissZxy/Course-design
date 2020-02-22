package cn.bjst.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import cn.bjst.util.Constant;

public class Bullet extends GameObject{

    int speed=5;
    double degree;

    
    public Bullet() {
    	degree= Math.random()*Math.PI*2;
    	x=Constant.GAME_WIDTH/2;
    	y=Constant.GAME_HEIGHT/2;
        width=10;
        height=10;
    
    }
    

    public void draw(Graphics g) {
    	Color c=g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int) y, width, height);
        g.setColor(c);
        
        x +=speed*Math.cos(degree);
        y +=speed*Math.sin(degree);
        
        if(y>Constant.GAME_HEIGHT-height||y<30) {//反弹的计算
        	degree = -degree;
        }
        
        if(x<0||x>Constant.GAME_WIDTH-width) {   //反弹的计算
        	degree =Math.PI-degree;
        }
    }
	
	
}

 