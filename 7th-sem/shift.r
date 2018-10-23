m<-c(1,2,2,6,5,7)
p<-matrix(m,nrow=3,ncol=2)
s<-c(-1,-2)
print(p)
for(i in 1:dim(p)[1]-1){
    for(j in 1:dim(p)[2]){
        t=p[i+1,j]
        p[i+1,j]=s[j]
        s[j]=t
    }
}
for (i in 1:dim(p)[2]){
    p[1,i] = s[i] 
}

print(p)