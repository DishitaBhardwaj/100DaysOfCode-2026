bool areOccurrencesEqual(char *s) {
    int freq[26] = {0};

    while (*s) {
        freq[*s - 'a']++;
        s++;
    }

    int count = 0;

    for (int i = 0; i < 26; i++) {
        if (freq[i] != 0) {
            if (count == 0)
                count = freq[i];
            else if (freq[i] != count)
                return false;
        }
    }

    return true;
}
