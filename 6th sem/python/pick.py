import pickle
e = [1,2,4]
D = {'a': 1, 'b': 2}
F = open('objectae.txt', 'wb')

pickle.dump(e, F)
pickle.dump(D, F)
F.close()