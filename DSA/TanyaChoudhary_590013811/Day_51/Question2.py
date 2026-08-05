def find_first_invalid_record(records):
    seen = {}
    for index, (vendor_id, lot_number, cert_code) in enumerate(records):
        key = (vendor_id, lot_number)
        if key in seen:
            if seen[key] != cert_code:
                return index
        else:
            seen[key] = cert_code
    return -1


if __name__ == "__main__":
    records = [
        ["V1", "L100", "C1"],
        ["V2", "L200", "C2"],
        ["V1", "L100", "C1"],
        ["V1", "L100", "C3"],
        ["V3", "L300", "C1"],
    ]
    print(find_first_invalid_record(records))