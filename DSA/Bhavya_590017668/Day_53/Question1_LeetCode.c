int countGoodSubstrings(char* s) {
    int count = 0;
    for (int i = 0; s[i + 2] != '\0'; i++) {
        if (s[i] != s[i + 1] &&
            s[i] != s[i + 2] &&
            s[i + 1] != s[i + 2]) {
            count++;
        }
    }
    return count;
}