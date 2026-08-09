/*Remove Outermost Parentheses
Explanation
Remove the outermost parentheses from each primitive valid parentheses string using efficient stack tracking.*/

char* removeOuterParentheses(char* s) {
    char stack[10001];
    int top = -1;
    int i, j = 0;

    for(i = 0; s[i] != '\0'; i++){
        if(s[i] == '('){
            if(top != -1){
                s[j++] = '(';
            }
            stack[++top] = '(';
        }
        else{
            top--;
            if(top != -1){
                s[j++] = ')';
            }
        }
    }

    s[j] = '\0';
    return s;
}