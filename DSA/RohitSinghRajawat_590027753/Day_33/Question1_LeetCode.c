char* removeOuterParentheses(char* s)
{
    char stack[10001];
    int top = -1;

    char* ans = (char*)malloc((strlen(s) + 1) * sizeof(char));
    int k = 0;

    for(int i = 0; s[i] != '\0'; i++)
    {
        if(s[i] == '(')
        {
            if(top != -1)
            {
                ans[k++] = '(';
            }

            stack[++top] = '(';
        }
        else
        {
            top--;

            if(top != -1)
            {
                ans[k++] = ')';
            }
        }
    }

    ans[k] = '\0';

    return ans;
}