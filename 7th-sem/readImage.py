from PIL import Image
import cv2
import argparse
import math


def maxColor(image,sizeI):
    d={}
    for i in range(sizeI[0]):
        for j in range(sizeI[1]):
            r = int(image[i][j][2])
            g = int(image[i][j][1])
            b = int(image[i][j][0])
            if(r,g,b) in d.keys():
                    d[(r,g,b)] +=1
            else:
                d[(r,g,b)] = 1

    max = -1
    label1 = 0
    label2 = 0
    label3 = 0
    for key in d.keys():
        if max < d[key]:
            label1 = key[0]
            label2 = key[1]
            label3 = key[2]
            max = d[key]
    print(d,"\n-----\n----\n",max)


image = Image.open('out.tif')
image2 = cv2.imread("5gt.tif")

size = image2.shape
maxColor(image2,size)
#print(image,"++++++++++++++\n")

