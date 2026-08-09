def first_invalid_record(records):
    seen = {}

    for i, (vendor_id, lot_number, cert_code) in enumerate(records):
        key = (vendor_id, lot_number)

        if key in seen:
            if seen[key] != cert_code:
                return i
        else:
            seen[key] = cert_code

    return -1

n = int(input("Enter number of records: "))

records = []
print("Enter records (vendor_id lot_number cert_code):")
for _ in range(n):
    vendor_id, lot_number, cert_code = input().split()
    records.append((vendor_id, lot_number, cert_code))

print("First invalid record index:", first_invalid_record(records))