String printerWars(String jobs) {
    Queue<Integer> s = new LinkedList<>();
    Queue<Integer> m = new LinkedList<>();

    int n = jobs.length();

    for (int i = 0; i < n; i++) {
        if (jobs.charAt(i) == 'S')
            s.offer(i);
        else
            m.offer(i);
    }

    while (!s.isEmpty() && !m.isEmpty()) {
        int a = s.poll();
        int b = m.poll();

        if (a < b)
            s.offer(a + n);
        else
            m.offer(b + n);
    }

    return s.isEmpty() ? "Marketing" : "Sales";
}