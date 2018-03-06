#!/bin/python3

import sys

class hashabledict(dict):
    def ha(self,d):
        s=""
        for key in d.keys():
            for i in range(d[key]):
                s+=key
        return s

def sherlockAndAnagrams(s):
    # Complete this function
    d={}
    for i in range(len(s)):
        t={}
        for j in range(i,len(s)):
            if s[j] not in t:
                t[s[j]]=1
            else:
                t[s[j]]=t[s[j]]+1
            
            yu=hashabledict()
            st=yu.ha(t)
            #print(st)
            if st not in d:
                d[st]=1
            else:
                d[st]=d[st]+1
                
                    
    r=0
    for keys in d.keys():
        y=(d[keys]*(d[keys]-1))

        print(y)
        t=(y/2)
        #print(t)
        r+=t
    return r

q = int(input().strip())
for a0 in range(q):
    s = input().strip()
    result = sherlockAndAnagrams(s)
    print('%g'%(result))

