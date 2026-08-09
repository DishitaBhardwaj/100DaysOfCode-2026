#pragma GCC optimize("Ofast")

#include <bits/stdc++.h>
using namespace std;

static constexpr size_t max_align = alignof(max_align_t);
alignas(max_align) static unsigned char BUFFER[64 * 1024 * 1024];
static size_t pos = 0;

void *operator new(const size_t size) {
    const size_t padding = (max_align - (pos % max_align)) % max_align;
    pos += padding + size;
    return static_cast<void *>(&BUFFER[pos - size]);
}

void *operator new[](const size_t size) { return operator new(size); }
void operator delete(void *) noexcept {}
void operator delete[](void *) noexcept {}
void operator delete(void *, size_t) noexcept {}
void operator delete[](void *, size_t) noexcept {}


class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {

        sort(arr.begin(), arr.end());

        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.size(); i++) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }

        return true;
    }
};