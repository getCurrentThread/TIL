#include<bits/stdc++.h>  
using namespace std;
  int main(){
      // 완전수 (1000~9999)
      for(int n=1000;n<=9999;n++){
          int s=0;
          for(int i=1;i<n;i++) if(n%i==0) s+=i;
          if(s==n) cout<<n<<" ";
      }
      cout<<"\n";
      // 각 자릿수 세제곱합 (100~999)
      for(int n=100;n<=999;n++){
          int s=0,tmp=n;
          while(tmp){s+=pow(tmp%10,3);tmp/=10;}
          if(s==n) cout<<n<<" ";
      }
  }
