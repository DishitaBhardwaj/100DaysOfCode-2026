class Solution {
    public String predictPrinter(String jobs) {
        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();
        int size = jobs.length();

        for (int i = 0; i < jobs.length(); i++) {
            if (jobs.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                marketing.offer(i);
            }
        }

        while (!sales.isEmpty() && !marketing.isEmpty()) {
            int s = sales.poll();
            int m = marketing.poll();

            if (s < m) {
                sales.offer(s + size);
            } else {
                marketing.offer(m + size);
            }
        }

        if (marketing.isEmpty()) {
            return "Sales";
        } else {
            return "Marketing";
        }
    }
}