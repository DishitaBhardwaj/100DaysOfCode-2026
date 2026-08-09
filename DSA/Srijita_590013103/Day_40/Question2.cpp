class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& temperatures, int k) {

        deque<int> dq;
        vector<int> ans;

        for(int i = 0; i < temperatures.size(); i++) {

            while(!dq.empty() && dq.front() <= i - k)
                dq.pop_front();

            while(!dq.empty() && temperatures[dq.back()] <= temperatures[i])
                dq.pop_back();

            dq.push_back(i);

            if(i >= k - 1)
                ans.push_back(temperatures[dq.front()]);
        }

        return ans;
    }
};