def firstInvalidRecord(deliveries):
    records = {}
    for i, (vendor, lot, cert) in enumerate(deliveries):
        key = (vendor, lot)
        if key in records:
            if records[key] != cert:
                return i
        else:
            records[key] = cert
    return -1
n = int(input())
deliveries = []
for _ in range(n):
    vendor, lot, cert = input().split()
    deliveries.append([vendor, lot, cert])
print(firstInvalidRecord(deliveries))