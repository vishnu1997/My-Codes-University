sigmoid=function(x)
{
  1/(1+exp(-x))
}
alp = 0.1
w1 = matrix(c(0.1,.3,.2,.4,.3,.1),ncol=3)

w2 = matrix(c(1,2,3),ncol=1)

d = matrix(c(1,0,0,1,1,0,1,0),nrow=4,ncol=2)
t = matrix(c(0,0,1,1),nrow=4,ncol=1)

mse = 0.01

start = 1

while (start<5){
  
}

