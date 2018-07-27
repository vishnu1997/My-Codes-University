input_array = list(map(int,input().split()))

input_array.sort()
first = 0 
last = len(input_array)-1
output = []

while(first<=last):
    output.append(input_array[last])
    output.append(input_array[first])
    first+=1
    last-=1
    if (first==last):
        output.append(input_array[first])
        break
    
print(output)
    