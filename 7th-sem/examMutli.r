wer = function(er){
  s = array(0,dim=c(1,dim(er)[2]))
  for(i in 1:dim(er)[1]-1){
    for(j in 1:dim(er)[2]){
      t=er[i+1,j]
      er[i+1,j]=s[j]
      s[j]=t
    }
  }
  for (i in 1:dim(er)[2]){
    er[1,i] = s[i] 
  }
  return(er)
}
sigmoid=function(x)
{
  1/(1+exp(-x))
}
alp=0.1
#w1=matrix(runif(2*3),ncol=3)
w1=matrix(c(-0.16595599,-0.39533485,0.44064899,-0.70648822,-0.99977125,-0.81532281),ncol=3)

print(w1)
#w2=matrix(runif(3*1),ncol=1)
w2=matrix(c(-0.62747958,-0.30887855,-0.20646505),ncol=1)

d=matrix(c(0,0,1,1,0,1,0,1),nrow=4,ncol=2)
t=matrix(c(0,1,1,0),nrow=4,ncol=1)

mse=0.01

start=1
while(mse>0.005&& start<2)
{
  a=d%*%w1
  mse=0
  hd1=matrix(0,nrow=4,ncol=3)
  #print(a)
  for(i in 1:4)
  {
    for(j in 1:3)
    {
      hd1[i,j]=sigmoid(a[i,j])
    }
  }
  #print(hd1)
  b=hd1%*%w2

  #print(b)
  hd2=matrix(0,nrow=4,ncol=1)
  for(i in 1:4)
  {
    for(j in 1:1)
    {
      hd2[i,j]=sigmoid(b[i,j])
    }
  }
  #print(hd2)
  
  u=matrix(1,nrow=4,ncol=1)
  v=u-hd2
  rt = t-hd2
  dk=matrix(0,nrow=4,ncol=1)
  for(i in 1:4)
  {
    for(j in 1:1)
    {
      dk[i,j]=hd2[i,j]*v[i,j]*rt[i,j]
    }
  }

  z=t(w2)
  p=hd2%*%z
  u1=matrix(1,nrow=4,ncol=3)
  q=u1-hd1
  dh=matrix(0,nrow=4,ncol=3)
  for(i in 1:4)
  {
    for(j in 1:3)
    {
      dh[i,j]=hd1[i,j]*q[i,j]*p[i,j]
    }
  }

  z1=t(d)
  rr=z1%*%dh
  for(i in 1:2)
  {
    for(j in 1:3)
    {
      w1[i,j]=w1[i,j]-(alp*rr[i,j])
    }
  }

  mse=0
  for(i in 1:4)
  {
    mse=mse+((t[i,1]-hd2[i,1])*(t[i,1]-hd2[i,1]))
  }
  mse = mse/32;
  print(mse)

  d = wer(d)
  t = wer(t)
  start=start+1;

}
print(w1)
