//#include<iostream>
#include<stdio.h>
//using namespace std;


void cc(int alloc[10][10],int dm[10][10],int np,int nr);

void rem(int need[10][10],int claim[10][10],int alloc[10][10],int allr[10],int p,int nr);

int chk(int dm[10][10],int need[10][10],int allr[10],int p,int np,int nr);

void pri(int ma[10][10],int np,int nr){
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            printf("process --------%d:need :%d:::",i,j);
            printf("%d\n",ma[i][j]);
        }}
}

int main(){
    int np,nr,ch,rr;
    //cout<<"enter the no.of process\n";
    printf("enter the no.of process :");
    //cin>>np;
    scanf("%d",&np);    
    printf("enter the no.of process :");
    //cout<<"enter no.of resources";
    //cin>>nr;
    scanf("%d",&nr);    
    int alloc[np][nr],claim[np][nr];int need[np][nr],dm[np][nr],ned[np][nr];
    int av[nr],allr[nr],rq[nr],fk[nr];
    //cout<<"enter allocated matrix";
    printf("enter allocated matrix");
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            //cout<<"enter alloc"<<np<<"::"<<nr<<" ";
            printf("enter alloc %d :: %d :",i,j);
            //cin>>alloc[i][j];
                scanf("%d",&alloc[i][j]);
        }
    }
   

    //cout<<"enter claim matrix";
    printf("enter claim matrix\n");
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
         //   cout<<"enter claim"<<np<<"::"<<nr<<" ";
            printf("enter claim %d ::: %d :",i,j);
           // cin>>claim[i][j];
           scanf("%d",&claim[i][j]);           
            need[i][j]=claim[i][j]-alloc[i][j];
            printf("neeedd %d.....claim[:%d,,,,,,alloc[][]:%d----\n",need[i][j],claim[i][j],alloc[i][j]);
        }
    }
    pri(need,np,nr);
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            printf("process %d:res :%d:::",i,j);
            printf("%d\n",need[i][j]);
        }}
    for(int i=0;i<nr;i++){
        //cout<<"enter total res for"<<nr<<" ";
        printf("enter total res for %d:",i);
        //cin>>av[i];
        scanf("%d",&av[i]);
        fk[i]=0;
    }
    
    for(int i=0;i<nr;i++){
        for(int j=0;j<np;j++){
            fk[i]+=alloc[j][i];
        }
        allr[i]=av[i]-fk[i];
    }
    

    ch=1;rr=0;
    int p;
    //cc(alloc,dm,np,nr);//--------------------
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            
            dm[i][j]=alloc[i][j];
        
        }
    }
    //---------------------------
    while(ch){


        printf("allocation matrix\n");
        for(int i=0;i<np;i++){
            for(int j=0;j<nr;j++){
                printf("process %d:res :%d:::",i,j);
                printf("%d\n",alloc[i][j]);
            }}

       // cout<<"enter 1 for new request,enter 0 to exit;\n";
        printf("enter 1 for new and 0 for exit :");
        //cin>>ch;
        scanf("%d",&ch);        
        if(ch==1){
            
          //  cout<<"enter process \n"
            printf("enter process nu :");   
            //cin>>p;
            scanf("%d",&p);            
            //cout<<"enter the resources\n";
            for(int i=0;i<nr;i++){
              //  cout<<"enter r"<<i<<" ";
                printf("enter res %d::",i);
                //cin>>rq[i];
                scanf("%d",&rq[i]);                
            }

//----------
printf("claim matrix\n");
for(int i=0;i<np;i++){
    for(int j=0;j<nr;j++){
        printf("process %d:res :%d:::",i,j);
        printf("%d\n",claim[i][j]);
    }}

//-------------
            //check if > claim
            for(int i=0;i<nr;i++){
                printf("what teh hell%d",alloc[p][i]+rq[i]);
                if(!(claim[p][i]>=(alloc[p][i]+rq[i]))){
                  //  cout<<"requesting more than claimed";
                    printf("requestion more than claimed\n");
                    rr=1;
                                        break;

                }
            }
            if(rr==1){
                continue;
            }rr=0;
            for(int i=0;i<nr;i++){
                if(!(allr[i]>=rq[i])){
                    //cout<<"requesting more than available with sys";
                    printf("resquesting more than resources available\n");
                    rr=1;break;
                }
            }
            if(rr==1){
                continue;
            }rr=0;
            //-------------------------
            //cc(need,ned,np,nr);
            for(int i=0;i<np;i++){
                for(int j=0;j<nr;j++){
                    
                    ned[i][j]=need[i][j];
                
                }
            }//---------------
            printf("ned matrix\n");
            for(int i=0;i<np;i++){
                for(int j=0;j<nr;j++){
                    printf("process %d:res :%d:::",i,j);
                    printf("%d\n",ned[i][j]);
                }}
            
            //-------------------------
            for(int i=0;i<nr;i++){
                printf("maggi111111 need %d \n",ned[p][i]);
                ned[p][i]-=rq[i];
                dm[p][i]+=rq[i];
                allr[i]-=rq[i];
                
                printf("maggi2222 needs %d \n",ned[p][i]);
            }
            //pri(ned,np,nr);//=-----------------------
            int pr=0;
            for(int ut=0;ut<np;ut++){
            for(int i=0;i<np;i++){
                int k=0;
                for(int j=0;j<nr;j++){
                    if(ned[i][j]<=allr[i]){
                        k++;
                    }
                }
                printf("entered k %d:::%d",i,k);
                if(k==nr){
                    for(int u=0;u<nr;u++){
                        allr[u]+=ned[i][u];
                        printf("uuu  %d ",ned[i][u]);
                        ned[i][u]=1000;
                    }
                    printf("entered -----%d",i);
                    pr++;
                }
            }
        
        }
        
       // printf
                
        


            //---------------------------------
            if(pr==np){
                int uto=0;
                for(int i=0;i<nr;i++){
                  alloc[p][i]=alloc[p][i]+rq[i]; 
                  allr[i]-=rq[i];
                }
                for(int i=0;i<nr;i++){
                    if(alloc[p][i]==claim[p][i]){
                        uto++;
                    }  
                }

                if(uto==nr){//--------------------------
                    //rem(need,claim,alloc,allr,p,nr);
                    for(int i=0;i<nr;i++){
                        need[p][i]=0;
                        claim[p][i]=0;
                        allr[i]+=alloc[p][i]; 
                        alloc[p][i]=0; }
                    
                    //-----------------------------
                }else{
                    for(int i=0;i<nr;i++){
                        need[p][i]-=rq[i];
                    }
                }

                  //cc(alloc,dm,np,nr);//--------------------
                    for(int i=0;i<np;i++){
                        for(int j=0;j<nr;j++){
            
                            dm[i][j]=alloc[i][j];
        
                             }
                         }
                    //---------------------------
               // pri(alloc,np,nr);
            }else{
                for(int i=0;i<nr;i++){
                    allr[i]+=rq[i];
                    
                }
               // cout<<"Not safe";
                printf("not safe\n");
            }
       }
   }


    return 0;
}

void cc(int alloc[10][10],int dm[10][10],int np,int nr){
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            
            dm[i][j]=alloc[i][j];
        
        }
    }
}

void rem(int need[10][10],int claim[10][10],int alloc[10][10],int allr[10],int p,int nr){
    for(int i=0;i<nr;i++){
        need[p][i]=0;
        claim[p][i]=0;
        allr[i]+=alloc[p][i]; 
        alloc[p][i]=0; 
    }
}

int chk(int dm[10][10],int need[10][10],int allr[10],int p,int np,int nr){
    int pr=0;
    for(int ut=0;ut<np;ut++){
    for(int i=0;i<np;i++){
        int k=0;
        for(int j=0;j<nr;j++){
            if(need[i][j]<=allr[i]){
                k++;
            }
        }
        printf("entered k %d:::%d",i,k);
        if(k==nr){
            for(int u=0;u<nr;u++){
                allr[u]+=need[i][u];
                printf("uuu  %d ",need[i][u]);
                need[i][u]=1000;
            }
            printf("entered k %d",i);
            pr++;
        }
    }}


    if(pr==np){
        return 1;
    }else{return 0;}
}
