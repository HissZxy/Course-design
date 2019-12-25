#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define max 10
int PN;//Process number ��������
int RT;//Resource types ��Դ����
int Resourse[max];//��Դ
int Request[max];//����
int Avaliable[max];//ϵͳʣ����Դ
int	MAX[max][max];//���������Դ����
int Need[max][max];//����Ŀǰ��Դ����
int Allocation[max][max];//�����ѷ�����Դ
int SafeOrder[max];//��ȫ����
int choice;//��������ѡ��
void Menu()
{
	printf("------------------what you want-------------------\n");
	printf("*              1.��ʼ������                      *\n");
	printf("*              2.����T0ʱ�̰�ȫ��                *\n");
	printf("*              3.��Դ����                        *\n");
	printf("*              4.�˳�                           *\n");
	printf("------------------------------------------------\n");
}
void Input(int a, int b, int c[max][max])
{
	int i;
	for (i = 0; i < b; i++)
	if (i == 0) printf("   R%d ", i + 1);
	else printf("R%d ", i + 1);
	printf("\n");
	for (i = 0; i < a; i++)
	{
		printf("P%d  ", i + 1);
		for (int j = 0; j < b; j++)
			scanf("%d", &c[i][j]);
	}
}
void init()
{
	int i, j;
	printf("��ʼ��: ��������̸�������Դ����: ");
	scanf("%d%d", &PN, &RT);
	printf("�����������Դ����: \n");
	for (i = 0; i < RT; i++)
		printf("R%d ", i + 1);
	printf("\n");
	for (i = 0; i < RT; i++)
		scanf("%d", &Resourse[i]);
	printf("������ÿ�����̶�ÿ����Դ�����������:\n");
	Input(PN, RT, MAX);
	printf("�����������Դ�ѷ�����:\n");
	Input(PN, RT, Allocation);
	for (i = 0; i < PN; i++)
	for (j = 0; j < RT; j++)
		Need[i][j] = MAX[i][j] - Allocation[i][j];
	for (i = 0; i < RT; i++)
	{
		int sum[max] = { 0 };
		for (j = 0; j < PN; j++)
			sum[i] += Allocation[j][i];
		Avaliable[i] = Resourse[i] - sum[i];
	}
}
bool  Apply()//������Դ����
{
	int i;
	printf("ѡ��������Դ�Ľ���: P");
	scanf("%d", &choice);
	printf("���������Դ��������\n");
	for (i = 0; i < RT; i++)
		printf("R%d ", i + 1);
	printf("\n");
	for (i = 0; i < RT; i++)
		scanf("%d", &Request[i]);
	for (i = 0; i < RT; i++)
	if (Request[i] <= Need[choice - 1][i])
	{
		if (Request[i] > Avaliable[i])
		{
			printf("��Դ���㣡"); return false;
		}
	}
	else
	{
		printf("���볬�����裡"); return false;
	}
	return true;
}
bool IsSafe()
{
	int i, j, k = 0, count, Work[max];
	bool Finish[max];
	for (i = 0; i < PN; i++)
		Finish[i] = false;
	for (i = 0; i < RT; i++)
		Work[i] = Avaliable[i];
	for (i = 0; i < PN; i++)
	{
		count = 0, j = 0;
		if (Finish[i] == false)
		{
			for (j = 0; j < RT; j++)
			if (Need[i][j] <= Work[j])
				count++;
		}
		if (count == RT)
		{
			for (j = 0; j<RT; j++)
				Work[j] += Allocation[i][j];
			Finish[i] = true;
			SafeOrder[k++] = i + 1;
			i = -1;//�ؼ�,Ҳ���Զ�iȡģ
		}

	}
	for (i = 0; i < PN; i++)
	if (Finish[i] == false)
		return false;
	return true;
}
bool banker()
{
	bool temp;
	int i = choice - 1, j;
	for (j = 0; j < RT; j++)//�Է���
	{
		Avaliable[j] -= Request[j];
		Allocation[i][j] += Request[j];
		Need[i][j] -= Request[j];
	}





	for (j = 0; j < RT; j++){
		if (Need[i][j] == 0){
			temp = true;
		}
		else{
			temp = false;
			break;
		}

	}
	for( j = 0; j < RT;j++){
		if (temp){
			Avaliable[j] += Allocation[i][j];
			Allocation[i][j] = 0;
		}
	}






	if (IsSafe()) return true;
	else//�������أ��ظ�ԭ��״̬
	{
		for (j = 0; j<RT; j++)
		{
			Avaliable[j] += Request[j];
			Allocation[i][j] -= Request[j];
			Need[i][j] += Request[j];
		}
		return false;
	}
	return true;
}
void printOrder()//�����ȫ����
{
	int i;
	for (i = 0; i < PN; i++)
	{
		if (i == 0)
			printf("P%d", SafeOrder[i]);
		else
			printf("->P%d", SafeOrder[i]);
	}
	printf("\n");
}












void print()
{
	int i, j;
	printf("ϵͳʣ��: \n");
	for (i = 0; i < RT; i++)
		printf(" R%d", i + 1);
	printf("\n");
	for (i = 0; i < RT; i++)
		printf("%3d", Avaliable[i]);
	printf("\nϵͳ�ѷ���: \n");
	for (i = 0; i < RT; i++)
	if (i == 0) printf("    R%d", i + 1);
	else printf(" R%d", i + 1);
	printf("\n");
	for (i = 0; i < PN; i++)
	{
		printf("P%d", i + 1);
		for (j = 0; j < RT; j++)
			printf("%3d", Allocation[i][j]);
		printf("\n");
	}
	printf("ϵͳ����: \n");
	for (i = 0; i < RT; i++)
	if (i == 0) printf("    R%d", i + 1);
	else printf(" R%d", i + 1);
	printf("\n");
	for (i = 0; i < PN; i++)
	{
		printf("P%d", i + 1);
		for (j = 0; j < RT; j++)
			printf("%3d", Need[i][j]);
		printf("\n");
	}
}
int  main()
{
	bool flag;
	Menu();
Initialization:init();
	if (IsSafe() == false)
	{
		printf("��ǰϵͳ״̬����ȫ!\n�����³�ʼ������");
		goto Initialization;
	}
	else
	{
		printf("��ǰϵͳ���ڰ�ȫ״̬,��ȫ����Ϊ:  ");
		printOrder();
		print();
	}
Application: flag = Apply();
	if (flag == false)
	{
		printf("����ʧ��!����������\n");
		goto Application;
	}
	else
	{
		if (banker() == false)
		{
			printf("��Դ�������ϵͳ��������״̬!����ʧ��!����������\n");
			goto Application;
		}
		else
		{
			printf("����ɹ�!��ȫ����Ϊ:  ");
			printOrder();
			print();
		}
	}
	int n;
	printf("�Ƿ��н���������Դ? ��������1,��������0 :");
	scanf("%d", &n);
	if (n == 1)
		goto Application;
	return 0;
}

