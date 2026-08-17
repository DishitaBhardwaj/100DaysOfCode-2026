lass Solution {
    public int firstInvalidRecord(String[][] deliveries) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.length; i++) {
            String vendor = deliveries[i][0];
            String lot = deliveries[i][1];
            String cert = deliveries[i][2];

            String key = vendor + "#" + lot;

            if (!map.containsKey(key)) {
                map.put(key, cert);
            } else if (!map.get(key).equals(cert)) {
                return i;
            }
        }

        return -1;
    }
}