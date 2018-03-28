input = open("test.txt")
d ={}
for line in input: 
    (key, val) = line.split()
    d[key] = val
print(d)