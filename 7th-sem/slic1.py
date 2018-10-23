# USAGE
# python superpixel_segments.py --image nedry.png

# import the necessary packages
from skimage.segmentation import slic
from skimage.measure import regionprops
from skimage.segmentation import mark_boundaries
from skimage.util import img_as_float
from skimage.io import imsave
import matplotlib.pyplot as plt
import numpy as np
import argparse
import cv2
import math


def addOne(segment):
	for i in range(len(segment)):
		for j in range(len(segment[i])):
			segment[i][j] += 1
	return segment
	
	
windowSize = 10
	
# construct the argument parser and parse the arguments
ap = argparse.ArgumentParser()
ap.add_argument("-i", "--image", required = True, help = "Path to the image")
args = vars(ap.parse_args())

# load the image and apply SLIC and extract (approximately)
# the supplied number of segments
image = cv2.imread(args["image"])
segments = slic(img_as_float(image), n_segments = 4, sigma = 5,convert2lab=True)
size = image.shape
print(size)
# show the output of SLIC
fig = plt.figure("Superpixels")
ax = fig.add_subplot(1, 1, 1)
ax.imshow(mark_boundaries(img_as_float(cv2.cvtColor(image, cv2.COLOR_BGR2RGB)), segments))
plt.axis("off")
plt.show()


csegments = addOne(segments)
print(csegments)
props = regionprops(csegments)
np.savetxt('textWord.txt',csegments,fmt='%d')
y = np.loadtxt('textWord.txt',dtype=np.object)

print("\n-------",y)

for i in range(len(y)):
	for j in range(len(y[i])):
		print(y[i][j][0])
		


# centroids = []
# x=[]
# y=[]
# for prop in props:
    	
# 	#centriods.append(prop.centriod)
# 	x1,y1=prop.centroid
# 	print(x1,y1)
# 	x.append(int(round(x1)))
# 	y.append(int(round(y1)))  


# centroids.append(x)
# centroids.append(y)
# print("Centroid values are \n",centroids)


# # loop over the unique segment values
# print("Segments values are \n",segments)
# for (i, segVal) in enumerate(np.unique(segments)):
    	

# 	# construct a mask for the segment
# 	print("[x] inspecting segment ",(i))
# 	fileName = i+1
# 	mask = np.zeros(image.shape[:2], dtype = "uint8")
# 	mask[segments == segVal] = 255
# 	#print(mask)
	# show the masked region
	#cv2.imshow("Mask", mask)
	#m=cv2.bitwise_and(image, image, mask = mask)
	# segimg=np.zeros((10,10,3),dtype = 'uint8')
	# print(segimg)
	
	    						
	# 