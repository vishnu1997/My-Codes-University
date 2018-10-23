library(ggplot2)
data(iris)
ggplot(iris,aes(Sepal.Length,Sepal.Width,color=Species))+geom_point()
data = scale(iris[-5])
plot(data)
hist(data)
boxplot(data)
#-------------------
pi1 = c(10,20,30,30,NA,50)
names = c("a","a","a","a","a","a")
sc = round((pi1/sum(pi1))*100)
pie(pi1,lab=names,col=rainbow(length(pi1)))
#------------------------
qqww=data.frame(pi1,names)
qqww
rrw = is.na(qqww)
rrw
#-------------------------
data(mtcars)
dt = mtcars
head(dt)
de = iris

head(de)
de[,1:4]
ewr = prcomp(scale(de[,1:4]))
ewr$x
plot(ewr$x[,2],col=de$Species)
#---------------
y = c(50,120,32,21,123,12)
x = c(12,43,2,4,23,13)
ww = lm(y~x)
qa = c(120,50,10)
qq = data.frame(qa)
qq
rr=c()
a = data.frame(x=170)
for (eaxh in qq){
  a = data.frame(x = eaxh)
print(predict(ww,a))
  print(eaxh)
}
par(no.readonly = FALSE)
plot(y,x,abline(ww),pch=16,cex=1.3,lty=3,xlim=c(-20,140),ylim=c(-20,60))
dt
attach(dt)
newww=lm(mpg~.,dt)
wetest=dt[sample(1:nrow(dt),1),]
wetest
wete=wetest[,-1]
wete
oute = predict(newww,wete)
oute
#-----------------------------------

library(e1071)
data(Titanic)
Titanic_df = as.data.frame(Titanic)
Titanic_df
repiseq = rep.int(seq_len(nrow(Titanic_df)),Titanic_df$Freq)
repiseq
titdats = Titanic_df[repiseq,]
titdats
er = titdats
er $survied = NULL
naivebaam = naiveBayes(Species~.,iris) 
naiveBei = naiveBayes(Survived~.,er)
nbpredict = predict(naivebaam,iris)
nbpredict
nerpre = predict(naiveBei,er)
nerpre
p = table(nerpre,titdats$Survived)
ewe=table(nbpredict,iris$Species)
ewe
#------------------------------
acsv = read.csv("adult.csv",header = TRUE,sep=",")
head(acsv)
i1 = acsv[which(acsv$ABOVE50K==1),]
head(i1)
i0 = acsv[which(acsv$ABOVE50K==0),]
ii1=sample(1:nrow(i1),0.7*nrow(i1))
ri1 = i1[ii1,]
ri1
ii0=sample(1:nrow(i0),0.7*nrow(i0))
ri0 = i0[ii0,]
ti = rbind(ri1,ri0)
it1 = i0[-ii0,]
it0 = i1[-ii1,]
td = rbind(it0,it1)
td
rela = glm(ABOVE50K~RELATIONSHIP+AGE+CAPITALGAIN+OCCUPATION,data=acsv)
eee = predict(rela,td)
sd=table(td$ABOVE50K,eee)
head(sd,5)
summary(rela)
library(InformationValue)
misClassError(td$ABOVE50K,eee)
sensitivity(td$ABOVE50K,eee)
specificity(td$ABOVE50K,eee)
plot(td$ABOVE50K,eee)
qwqe=confusionMatrix(td$ABOVE50K,eee)
((qwqe[1,2]+qwqe[2,1])/sum(qwqe))
#----------------------------
head(wine[,-1])
head(factor(wine$V1))
irsC = kmeans(wine[,-1],3,nstart=10)
wt = table(irsC$cluster,wine$V1)
wt
irsC2 = kmeans(iris[,1:4],3,nstart=10)
wt2 = table(irsC2$cluster,iris$Species)
wt2
#----------------------------
library(datasets)
ds = hclust(dist(mtcars[sample(1:nrow(mtcars),7),]),"cen")
plot(ds)
#-----------------------------
library(mlbench)
library(caret)
data("PimaIndiansDiabetes")
cone = trainControl(method="repeatedcv",number=10,repeats = 3)
set.seed(7)
fit.cart= train(diabetes~.,data=PimaIndiansDiabetes,method="rpart",trControl=cone)
set.seed(7)
fit.lda = train(diabetes~.,data=PimaIndiansDiabetes,method = "lda",trControl=cone)
set.seed(7)
fit.knn=train(diabetes~.,data=PimaIndiansDiabetes,method = "svmRadial",trControl=cone)
results = resamples(list(CART=fit.cart,LDA=fit.lda,SVM=fit.knn))
summary(results)
sces = list(x=list(relation="free"),y=list(relation="free"))
bwplot(results,scales=sces)
densityplot(results,scales=sces)
dotplot(results,scales=sces)
xyplot(results,scales=sces)
parallelplot(results)
splom(results)
diss = diff(results)
diss
summary(diss)
#----------------------------------------
library(mlbench)
library(caret)
fd = trainControl(method="repeatedcv",number=10,repeats=3)
set.seed(7)
fit.cart=train(diabetes~.,method = "rpart",trControl=fd,data=PimaIndiansDiabetes)
set.seed(7)
fit.svm=train(diabetes~.,method = "svmRadial",trControl=fd,data=PimaIndiansDiabetes)
set.seed(7)
fit.knn=train(diabetes~.,method = "knn",trControl=fd,data=PimaIndiansDiabetes)
set.seed(7)
fit.rf=train(diabetes~.,method = "rf",trControl=fd,data=PimaIndiansDiabetes)
set.seed(7)
fit.lda=train(diabetes~.,method = "lda",trControl=fd,data=PimaIndiansDiabetes)
pre.ca = predict(fit.cart)
