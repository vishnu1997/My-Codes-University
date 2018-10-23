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

m<-c(1,2,2,6,5,7)
p<-matrix(m,nrow=3,ncol=2)
t = wer(p)
print(t)