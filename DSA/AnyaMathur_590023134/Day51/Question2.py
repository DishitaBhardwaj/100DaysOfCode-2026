# Problem 2 
# Receiving Log Validation

n = int(input("Enter number of delivery records: "))

deliveries = []

print("Enter vendor id, lot number and cert code for each record: ")
for i in range(n):
    deliveries.append(input().split())

records = {}
answer = -1

for i in range(len(deliveries)):
    vendor_id = deliveries[i][0]
    lot_number = deliveries[i][1]
    cert_code = deliveries[i][2]

    key = vendor_id + " " + lot_number

    if key not in records:
        records[key] = cert_code
    else:
        if records[key] != cert_code:
            answer = i
            break

print("First invalid record index:", answer)