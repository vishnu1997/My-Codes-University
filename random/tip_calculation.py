#code
def calculate_tip(waiter_A_tip,waiter_B_tip,x,y,position,maximum_tip):
	if position>=len(waiter_A_tip):
		return maximum_tip
	else:
		maxA = 0
		if x!=0:
			maxA = calculate_tip(waiter_A_tip,waiter_B_tip,x-1,y,position+1,maximum_tip+waiter_A_tip[position])
		maxB = 0
		if y!=0:
			maxB = calculate_tip(waiter_A_tip,waiter_B_tip,x,y-1,position+1,maximum_tip+waiter_B_tip[position])
		return maxA>maxB?maxA:maxB


no_of_test_cases = int(input())



for each_test_case in range(no_of_test_cases):
    details = list(map(int,input().split()))
    x = deatils[1]
    y = details[2]
    waiter_A_tip = list(map(int,input().split()))
    waiter_B_tip = list(map(int,input().split()))
    position = 0
    maximum_tip = 0
    maximum_tip = calculate_tip(waiter_A_tip,waiter_B_tip,x,y,position,maximum_tip)


