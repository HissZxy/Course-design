import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Allocation {
    static List <Area> e = new ArrayList<Area>();
    public static void alloction(Area a) //分配函数
    {
        int i;
        for( i = 0;i < e.size(); i++)
        {
            if(a.getSize() < (e.get(i)).getSize() && (e.get(i)).getFlag() == 0)
            {
                if((e.get(i)).getSize() - a.getSize() <= 2)
                {

                    (e.get(i)).setName(a.getName());
                }
                else
                {


                    a.setStartaddress((e.get(i)).getStartaddress());
                    (e.get(i)).setStartaddress((e.get(i)).getStartaddress() + a.getSize());
                    (e.get(i)).setSize((e.get(i)).getSize() - a.getSize());
                    e.add(i,a);
                }
                e.get(i).setFlag(1);
                System.out.println("分配成功！");
                break;
            }
        }
        if(i == e.size())
        {
            System.out.println("没有足够的空间可以分配！");
        }
    }


    public static void Recycle(String name) //回收函数
    {
        int i ;
        for(i = 0; i < e.size(); i++)
        {
            if(name.equals((e.get(i)).getName()))
            {

                if(i >= 1 && i < e.size() - 1)
                {
                    if((e.get(i - 1)).getFlag() == 0&&(e.get(i + 1)).getFlag() == 1) //回收区前一个空闲后一个占用状态时
                    {

                        (e.get(i - 1)).setSize((e.get(i - 1)).getSize() + (e.get(i)).getSize());
                        (e.get(i - 1)).setName("");
                        (e.get(i - 1)).setFlag(0);
                        e.remove(i);

                    }
                    else if((e.get(i + 1)).getFlag() == 0&&(e.get(i - 1)).getFlag() == 1) //回收区前一个占用后一个空闲状态时
                    {

                        (e.get(i)).setSize((e.get(i+1)).getSize() + (e.get(i)).getSize());
                        (e.get(i)).setName("");
                        (e.get(i)).setFlag(0);
                        e.remove(i + 1);

                    }
                    else if((e.get(i + 1)).getFlag() == 0&&(e.get(i - 1)).getFlag() == 0)//回收区前一个空闲后一个空闲状态时
                    {
                        (e.get(i - 1)).setSize((e.get(i - 1)).getSize() + (e.get(i)).getSize() + (e.get(i + 1)).getSize());
                        (e.get(i - 1)).setName("");
                        (e.get(i - 1)).setFlag(0);
                        e.remove(i);
                        e.remove(i);
                    }
                    else if((e.get(i + 1)).getFlag() == 1&&(e.get(i - 1)).getFlag() == 1)//回收区前一个占用后一个占用状态时
                    {
                        (e.get(i)).setName("");
                        (e.get(i)).setFlag(0);

                    }
                }
                else if(i == 0 && (e.get(i + 1)).getFlag() == 1)//当回收区为链表第一个并且回收区后一个为占用状态时
                {
                    (e.get(i)).setName("");
                    (e.get(i)).setFlag(0);
                }
                else if(i == 0 && (e.get(i + 1)).getFlag() == 0)//当回收区为链表第一个并且回收区后一个为空闲状态时
                {
                    (e.get(i)).setName("");
                    (e.get(i)).setSize((e.get(i+1)).getSize() + (e.get(i)).getSize());
                    (e.get(i)).setFlag(0);
                    e.remove( i+1);
                }
                else if(i == e.size() - 1 && (e.get(i - 1)).getFlag() == 1)//当回收区为链表最后一个并且回收区后一个为占用状态时
                {
                    (e.get(i)).setName("");
                    (e.get(i)).setFlag(0);
                }
                else if(i == e.size() - 1 && (e.get(i - 1)).getFlag() == 0)//当回收区为链表最后一个并且回收区后一个为空闲状态时
                {
                    (e.get(i-1)).setName("");
                    (e.get(i-1)).setSize((e.get(i-1)).getSize() + (e.get(i)).getSize());
                    (e.get(i)).setFlag(0);
                    e.remove( i);
                }
                System.out.println("回收成功！");
                break;
            }
        }
        if(i == e.size())
        {
            System.out.println("回收区名字错误！");
        }

    }


    public static void display()//显示函数
    {
        System.out.println("分区号\t作业名\t起始地址\t分区大小\t状态\t");
        for(int i = 0; i < e.size(); i++)
        {
            System.out.println((i+1)+"       /"+(e.get(i)).getName()+"      /"+(e.get(i)).getStartaddress()+"   /"+(e.get(i)).getSize()+"  /"+(e.get(i)).getFlag());
        }
    }

    public static void menu() //菜单函数
    {
        System.out.println("1.分配内存");
        System.out.println("2.回收内存");
        System.out.println("3.显示分配结果");
        System.out.println("4.退出");
        System.out.println("请选择要进行的操作：");
    }


}

