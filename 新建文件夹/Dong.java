
import java.util.Scanner;


public class Dong {
    public static void main(String[] args)
    {
        Area b = new Area("",1024,0,0);
        Allocation.e.add(b);
        Allocation.menu();
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        while(y >= 1 && y <= 4)
        {
            switch(y)
            {
                case 1:
                    System.out.println("请输入要分配的内存的名称：");
                    Scanner sd = new Scanner(System.in);
                    String c = sd.nextLine();
                    System.out.println("请输入要分配的内存的大小");
                    Scanner sa = new Scanner(System.in);
                    int q = sa.nextInt();
                    Area a = new Area(c,q);
                    Allocation.alloction(a);
                    break;
                case 2:
                    System.out.println("请输入要回收的内存的名称：");
                    Scanner se = new Scanner(System.in);
                    String w = se.nextLine();
                    Allocation.Recycle(w);
                    break;
                case 3:
                    Allocation.display();
                    break;
                case 4:
                    System.exit(0);

            }
            Allocation.menu();
            Scanner sf = new Scanner(System.in);
            y = sf.nextInt();
        }
    }


}