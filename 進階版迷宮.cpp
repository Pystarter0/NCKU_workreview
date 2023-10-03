#include<iostream>
#include<stack>
using namespace std;
int main()
{
	int map[7][7]={{0,1,1,0,0,0,0},{1,0,0,1,1,1,0},{1,1,1,0,1,1,0},{1,1,1,1,1,0,0},{1,1,1,1,0,1,0},{1,1,1,0,1,1,1},{1,1,1,0,0,0,0}};
	int pos[2]={0,0};
	stack<int> s;
	while (pos[0]!=6 or pos[1]!=6)
	{
		if (map[pos[0]][pos[1]+1]==0) //可往右 
		{
			pos[1]=pos[1]+1;
			s.push(1);
			map[pos[0]][pos[1]]=2;
		}
		else if (map[pos[0]+1][pos[1]+1]==0) //可往右下 
		{
			pos[1]=pos[1]+1;
			pos[0]=pos[0]+1;
			s.push(2);
			map[pos[0]][pos[1]]=2;
		}
		else if (map[pos[0]+1][pos[1]]==0) //往下 
		{
			pos[0]=pos[0]+1;
			s.push(3);
			map[pos[0]][pos[1]]=2;
		} 
		else if (map[pos[0]+1][pos[1]-1]==0) //往左下 
		{
			pos[0]=pos[0]+1;
			pos[1]=pos[1]-1;
			s.push(4);
			map[pos[0]][pos[1]]=2;
		} 
		else if (map[pos[0]][pos[1]-1]==0) //往左 
		{
			pos[1]=pos[1]-1;	
			s.push(5);	
			map[pos[0]][pos[1]]=2;	
		}
		else if (map[pos[0]-1][pos[1]-1]==0) //往左上 
		{
			pos[1]=pos[1]-1;	
			pos[0]=pos[0]-1;
			s.push(6);	
			map[pos[0]][pos[1]]=2;	
		}
		else if (map[pos[0]-1][pos[1]]==0) //往上 
		{
			pos[0]=pos[0]-1;
			s.push(7);
			map[pos[0]][pos[1]]=2;
		}
		else if (map[pos[0]-1][pos[1]+1]==0) //往右上 
		{
			pos[1]=pos[1]+1;
			pos[0]=pos[0]-1;
			s.push(8);
			map[pos[0]][pos[1]]=2;
		} //走過 //上方優先走過未走過的 後面才考慮有走過的 (走錯) 	
		else
		{
			int laststep=s.top();
			s.pop(); //刪除錯誤的一步 
			map[pos[0]][pos[1]]=1;
			if (laststep==1)
			{
				pos[1]=pos[1]-1;
			}
			else if (laststep==2)
			{
				pos[1]=pos[1]-1;	
				pos[0]=pos[0]-1;
			}
			else if (laststep==3)
			{
				pos[0]=pos[0]-1;
			}
			else if (laststep==4)
			{
				pos[1]=pos[1]+1;
				pos[0]=pos[0]-1;
			}
			else if (laststep==5)
			{
				pos[1]=pos[1]+1;
			}
			else if (laststep==6)
			{
				pos[1]=pos[1]+1;
				pos[0]=pos[0]+1;
			}
			else if (laststep==7)
			{
				pos[0]=pos[0]+1;
			}
			else if (laststep==8)
			{
				pos[0]=pos[0]+1;
				pos[1]=pos[1]-1;
			}
		} 
	}
	cout << "reach: ";
	while (s.top())
	{
		cout << s.top() << " ";
		s.pop();
	}
}
