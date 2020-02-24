package cn.bjst.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Date;
import cn.bjst.util.Constant;
import cn.bjst.util.GameUtil;
import cn.bjst.util.MyFrame;

public class PlaneGameFrame extends MyFrame{

   Image bg=GameUtil.getImage("images/bg.jpg");   
   Plane p =new Plane("images/plane.png",50,50);
  
   ArrayList bulletList = new ArrayList();//泛型暂时未学，学后强烈建议加上
     
   Explode bao ;
   Date startTime;
   Date endTime;
   
   public void paint(Graphics g) {
	   g.drawImage(bg, 0, 0, null);
	   p.draw(g);
	   
	   for(int i=0;i<bulletList.size();i++) {
		   Bullet b =(Bullet)bulletList.get(i);
		   b.draw(g);
		   
		   //检测跟飞机的碰撞
		   boolean peng =b.getRect().intersects(p.getRect());
		   
		   
		   if(peng) {
			   p.setLive(false);
			   
			   if(bao==null) {
			   endTime =new Date();
			   bao=new Explode(p.x,p.y);
			   }
			   bao.draw(g);
			   break;
			   
		   }
	   }
	   
	   if(!p.isLive()) {
		   printInfo(g,"Game Over",50,100,200,Color.WHITE);
		   int period =(int )(endTime.getTime()-startTime.getTime())/1000;
		   printInfo(g, "时间:"+period+"秒", 20, 120,260, Color.yellow);
	   switch (period/10) {
	    case 0:
	    	   printInfo(g, "等级-兵", 30, 110,230, Color.WHITE);
		break;
	    case 1:
	    	   printInfo(g, "等级-排", 30, 110,230, Color.GREEN);
		break;
	    case 2:
	    	   printInfo(g, "等级-连", 30, 110,230, Color.BLUE);
		break;
	    case 3:
	    	   printInfo(g, "等级-营", 30, 110,230, Color.PINK);
		break;

	    default:
		break;
	}
	   }
	  
   }
   
   
   /**
             在窗口上打印信息
    */
   
   
   public void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
	   Color c =g.getColor();
	   g.setColor(color);
	   Font   f =new Font("宋体",Font.BOLD,size);
	   g.setFont(f);
	   g.drawString(str,x,y);   
	   g.setColor(c);
	   
   }
   
   
   private Image offScreenImage =null;//利用双缓冲技术消除闪烁
   
   public void update(Graphics g) {
	   if(offScreenImage == null)
		   offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
	   
	   Graphics gOff =offScreenImage.getGraphics();
	   
	   paint(gOff);
	   g.drawImage(offScreenImage, 0, 0, null);
   }
   
     
   
   public static void main(String[] args) {
	   new PlaneGameFrame().launchFrame();
   }
   
   
   
   public void launchFrame() {
	   super.launchFrame();
	   //增加键盘的监听
	   addKeyListener(new KeyMonitor());
	   
	   //生成一堆子弹
	   for(int i=0;i<3;i++) {
		   Bullet b=new Bullet();
		   bulletList.add(b);
		   
	   }
	   startTime = new Date();
   }
   
    
   //定义内部类，可以方便的使用外部类的普通属性
   class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
      System.out.println("按下"+e.getKeyCode());
      p.addDirection(e);
      
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 System.out.println("释放"+e.getKeyCode());
		 p.minusDirection(e);
	}
	   
   }
   
}
