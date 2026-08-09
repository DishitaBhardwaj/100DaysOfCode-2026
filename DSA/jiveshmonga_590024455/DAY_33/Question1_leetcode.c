char* removeOuterParentheses(char* s) {
    int depth=0,j=0;

    for(int i=0;s[i]!='\0';i++)
    {
        if(s[i]=='(')
        {
            if(depth>0)
            {
                s[j++]=s[i];
            }
            depth++;
        }
        else
        {
            depth--;
            if(depth>0)
            s[j++]=s[i];
        }
    }   
    s[j]='\0';
    return s;
}