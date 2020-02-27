import  java.util.*;
 
public class Main
{
	public static void main(String args[])
	{
		int k1[]=new int[12];
		k1[0]=1;k1[1]=8;k1[2]=3;
		boolean kk[]=new boolean[13];   //看这些数字是否被填入过
		kk[1]=kk[8]=kk[3]=true;
		int k2[]={2,4,5,6,7,9,10,11,12};   //可以填取得数字
		
		Put(3,k1,k2,kk);           //3 是下一个需要填入的数组的下标
	}
	public static void Put(int i,int k1[],int k2[],boolean kk[])
	{
		if(i==12)
		{
			if(Check(k1)==true)    //检查是否满足每条边想等的条件
			{
				System.out.println(k1[6]);
				return ;
			}
			return ;
			
		}
		for(int j=0;j<k2.length;j++)
		{
			if(kk[k2[j]]==true)continue;
			else if(kk[k2[j]]==false)     // 说明这个数字还没填入过
			{
				k1[i]=k2[j];
				kk[k2[j]]=true;
			}
			Put(i+1,k1,k2,kk);      //填下一个
			kk[k2[j]]=false;    //回溯法   
		}
	}
	public static boolean Check(int k1[])   //检查6行是否想等
	{
		int t[]=new int[6];
		t[0]=k1[0]+k1[3]+k1[6]+k1[8];
		t[1]=k1[0]+k1[4]+k1[7]+k1[11];
		t[2]=k1[1]+k1[3]+k1[4]+k1[5];
		t[3]=k1[1]+k1[6]+k1[9]+k1[2];
		t[4]=k1[5]+k1[7]+k1[10]+k1[2];
		t[5]=k1[8]+k1[9]+k1[10]+k1[11];
		Arrays.sort(t);
		if(t[0]==t[5])return true;
		else return false;
		
	}
}