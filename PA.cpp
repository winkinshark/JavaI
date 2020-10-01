#include<bits/stdc++.h>
using namespace std;
#define ll long long 
int main()
{

	ll t,a,b;
	cin>> t;
	while(t--)
	{
		cin>>a>> b;
		if(a==b){cout<<0;continue;}
		vector<int> v(abs(a-b)+1,abs(a-b));
		v[0]=0;
		for(int i=1;i<v.size();i++)
		{
			v[i]=min(v[i],v[i-1]+1);
			if(i>=2)
				v[i]=min(v[i],v[i-2]+1);
			if(i>=5)
				v[i]=min(v[i],v[i-5]+1);
		}
		cout<<v[abs(a-b)]<<endl;
			
	}
	return 0;
}
/*
4 9
0 5 5 5 5 5 
  1 1  
*/
