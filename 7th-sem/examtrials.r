names = c("")
age <- c(1,3,5,2,11,9,3,9,12,3)
weight <- c(4.4,5.3,7.2,5.2,8.5,7.3,6.0,10.4,10.2,6.1)
dat = data.frame(age,weight)
Student <- c("John Davis", "Angela Williams", "Bullwinkle Moose",
             "David Jones", "Janice Markhammer", "Cheryl Cushing",
             "Reuven Ytzrhak", "Greg Knox", "Joel England",
             "Mary Rayburn")
Math <- c(502, 600, 412, 358, 495, 512, 410, 625, 573, 522)
Science <- c(95, 99, 80, 82, 75, 85, 80, 95, 89, 86)
English <- c(25, 22, 18, 15, 20, 28, 15, 30, 27, 18)

newdata = data.frame(Student,Math,Science,English)
newdata
par(no.readonly = FALSE)
plot(age,weight,xlab="weight",ylab="age",lty=2)
z = scale(dat)
z
sc = apply(z,1,mean)
sc
newweight = cbind(dat,sc)
newweight

we = newweight$weight>=mean(weight)
we =t(we)
we=data.frame(we)
we
#qwq = we[which(we=="FALSE"),]
qwq
newweight$result[we]<-"above avg"
newweight$result[newweight$weight<mean(weight)]<-"below avg"
#------------------------
library(ggplot2)
data("iris")
head(iris)
qqq=ggplot(iris,aes(x=Petal.Length,y=Sepal.Length,color=Species))+geom_point()
head(iris)
data=scale(iris[-5])
plot(data)
hist(data)
boxplot(data)
#------------------------------
slices = c(10,20,30,40,50)
names =c("aasda","basdas","casd","dasd","easd")
pet=round((slices/(sum(slices)))*100)

pet
pie(pet,lab=names,main="PIE CHART",col = rainbow(length((names))))
#-------------------------------
manager <- c(1, 2, 3, 4, 5)
date <- c("10/24/08", "10/28/08", "10/1/08", "10/12/08", "5/1/09")
country <- c("US", "US", "UK", "UK", "UK")
gender <- c("M", "F", "F", "M", "F")
age <- c(32, 45, 25, 39, 99)
q1 <- c(5, 3, 3, 3, 2)
q2 <- c(4, 5, 5, 3, 2)
q3 <- c(5, 2, 5, 4, 1)
q4 <- c(5, 5, 5, NA, 2)
q5 <- c(5, 5, 2, NA, 1)
leadership <- data.frame(manager, date, country, gender, age,q1, q2, q3, q4, q5)
leadership
missingValues = is.na(leadership)
missingValues
#---------------------------

library(MASS)
options(digits=3)
set.seed(1234)
mean <- c(230.7, 146.7, 3.6)
sigma <- matrix(c(11220.8, 6721.2, -47.1,6721.0,4700,-16.5,-43.5,2.3,1.2),nrow=3,ncol=3)
mydata <- mvrnorm(500, mean, sigma)
mydata <- as.data.frame(mydata)
names(mydata) <- c("y","x1","x2")
dim(mydata)
head(mydata)
#-----------------------------
set.seed(121)
d = matrix(runif(20,min=0,max=20),4,5)
d
dimnames(d)<-list(paste("sample",1:4),paste("var",1:5))
d
myPca = prcomp(d,scale. = FALSE,center=FALSE)
myPca
myPca$rotation
myPca$x
plot(myPca$x[,1])
wine <- read.table("http://archive.ics.uci.edu/ml/machine-learning-databases/wine/wine.data", sep=",")
head(wine)
# Name the variables
colnames(wine) <- c("Cvs","Alcohol","Malic acid","Ash","Alcalinity of ash", "Magnesium", "Total phenols", "Flavanoids", "Nonflavanoid phenols", "Proanthocyanins", "Color intensity", "Hue", "OD280/OD315 of diluted wines", "Proline")
wineClasses <- factor(wine$Cvs)
wineClasses
yiu=prcomp(scale(wine[,-1]))
yiu
plot(yiu$x[,3],col=wineClasses)
