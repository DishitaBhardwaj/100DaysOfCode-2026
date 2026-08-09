#include<iostream>
#include<queue>
using namespace std;
string printerWars(string jobs){
    queue<int>sales,marketing;

    int n = jobs.size();

    for(int i = 0;i<n;i++){
        if(jobs[i]=='S'){
            sales.push(i);
        }else{
            marketing.push(i);
        }
    }

    while(!sales.empty() && !marketing.empty()){
        int s  = sales.front();
        sales.pop();

        int m = marketing.front();
        marketing.pop();

        if(s<m){
            sales.push(s+n);
        }else{
            marketing.push(m+n);
        }
        return sales.empty()?"Marketing":"sales";
    }
    
};