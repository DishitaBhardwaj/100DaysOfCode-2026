def process(string):
    stack = []
    for char in string:
        if char == '#':
            if stack:
                stack.pop()
        else:
            stack.append(char)
    
    return ''.join(stack)