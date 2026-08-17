def register_usernames(requests):
    used = set()
    result = []

    for name in requests:
        if name not in used:
            used.add(name)
            result.append("OK")
        else:
            suffix = 1
            new_name = name + str(suffix)
            while new_name in used:
                suffix += 1
                new_name = name + str(suffix)
            used.add(new_name)
            result.append(new_name)

    return result


if __name__ == "__main__":
    requests = ["abacaba", "acaba", "abacaba", "acab"]
    print(register_usernames(requests))