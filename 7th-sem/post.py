import csv
import numpy as np
from skimage.io import imsave

with open('DataFile.csv', 'r') as csvfile:
    spamreader = csv.reader(csvfile, delimiter=',', quotechar='\n')

    y = np.loadtxt('textWord.txt',dtype=np.object)
    length = len(y)
    if (length == 0):
        print("No data in file")
    breadth = len(y[0])

    segimg=np.zeros((length,breadth,3),dtype = 'uint8')
    
    print("length : ",length," Breadth : ",breadth)
    value = list(spamreader)
    outclass = []
    d = {}
    d["Vishnu"]=[240,0,0]
    d["maggi"] = [0,240,0]
    d["masala"] = [0,0,240]
    d["same"] = [240,240,0]

    for i in range(len(value)):
        outclass.append(value[i][0])

    for i in range(len(y)):
        for j in range(len(y[i])):
            for k in range(3):
                segimg[i][j][k] = d[outclass[int(y[i][j])-1]][k]
    fileName = "out"
    imsave(str(fileName)+'.tif',segimg)
    # for row in spamreader:
    #     print ("--",row[0])

