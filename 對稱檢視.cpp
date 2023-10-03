#include<iostream>
#include<stack>
using namespace std;
int main()
{
	stack<int> s;
	stack<int> ms; //mirror
	stack<int> mms; //double mirror
	int n,m;
	int i,j;
	cout << "先輸入有幾個數，隨後輸入內容" << endl;
	while (cin>>n)
	{
		for (i=0;i<n;i++)
		{
			cin >> m;
			s.push(m); //原版 
			if (i<(n/2))
			{
				ms.push(m); //前一半之鏡像 
			}
		}
		for (i=0;i<(n/2);i++)
		{
			mms.push(s.top());
			s.pop();
		}
		m=0;
		for (i=(n/2);i<n;i++)
		{
			if (ms.top()==mms.top())
			{
				ms.pop();
				mms.pop();
				m+=1;
				if (m==(n/2))
				{
					cout << "對稱" << endl; 
					break;
				}
			}
			else
			{
				cout << "不對稱" << endl; 
				break;
			}	
		}
	}
	return 0;
}
