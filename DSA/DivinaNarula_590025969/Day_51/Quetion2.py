# Receiving Log Validation

def first_invalid_record(records):
    seen = {}

    for i in range(len(records)):
        vendor_id, lot_number, cert_code = records[i]

        key = (vendor_id, lot_number)

        if key in seen:
            if seen[key] != cert_code:
                return i
        else:
            seen[key] = cert_code

    return -1


n = int(input("Enter number of records: "))

records = []

print("Enter vendor_id, lot_number and cert_code for each record:")

for _ in range(n):
    vendor_id, lot_number, cert_code = input().split()
    records.append([vendor_id, lot_number, cert_code])

result = first_invalid_record(records)

print(result)