from typing import List

class Solution:
    def receivingLog(self, records: List[List[int]]) -> int:
        seen = {}

        for i, (vendor_id, lot_number, cert_code) in enumerate(records):
            key = (vendor_id, lot_number)

            if key in seen:
                if seen[key] != cert_code:
                    return i
            else:
                seen[key] = cert_code

        return -1