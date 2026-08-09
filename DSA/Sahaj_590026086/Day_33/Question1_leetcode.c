char* removeOuterParentheses(char* s){
    int count=0,idx=0;
    for (int i=0;s[i]!='\0';i++){
        if(s[i]=='('){
            if(count>0){
                s[idx++]=s[i];
            }
            count++;
        }else{
            count--;
            if(count>0){
                s[idx++]=s[i];
            }
        }
    }
    s[idx]='\0';
    return s;
}
