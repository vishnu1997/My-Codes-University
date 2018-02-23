import pickle

a=[1,3,5]
b='sastra'
f=open('pick.pkl','wb')
pickle.dump(a,f)
f.close()
