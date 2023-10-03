#include<iostream>
using namespace std;
int main(){
	int X[5]={3,7,5,9,1}; 
	int smallest,oldsmallest,pos;
	for (int i=0;i<5;i++){ 
		smallest=X[i]; 
		oldsmallest=X[i]; 
		for (int j=i;j<5;j++){ 
			if (X[j]<smallest){
				smallest=X[j];
				pos=j;
			}
			else if (X[j]==smallest){
				pos=j;
			}
		}
		X[i]=smallest;
		X[pos]=oldsmallest; 
		for (int k=0;k<5;k++){
			cout << X[k] << " ";
		}
		cout << endl;
	}
}
