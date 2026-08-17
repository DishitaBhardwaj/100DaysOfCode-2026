#Write an efficient function that processes a list of delivery records [vendor_id, lot_number, cert_code] in order and returns 
#the index of the first record where the same (vendor_id, lot_number) pair appears with a different cert_code than previously recorded, 
#or -1 if all records are valid.
#Example
#Refer to standard problem specifications on the platform for detailed inputs/outputs.
def first_invalid_record(records):
    seen = {}
    for i, (vendor_id, lot_number, cert_code) in enumerate(records):
        key = (vendor_id, lot_number)

        if key not in seen:
            seen[key] = cert_code
        elif seen[key] != cert_code:
            return i
    return -1

n = int(input())
records = []
for _ in range(n):
    vendor_id, lot_number, cert_code = input().split()
    records.append([int(vendor_id), int(lot_number), cert_code])
print(first_invalid_record(records))