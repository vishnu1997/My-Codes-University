#include<iostream>

using namespace std;


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

bool chk(int dm[10][10],int need[10][10],int allr[10],int p,int np,int nr){
    int pr=0;
    for(int ut=0;ut<np;ut++){
    for(int i=0;i<np;i++){
        int k=0;
        for(int j=0;j<nr;j++){
            if(need[i][j]<=allr[i]){
                k++;
            }
        }
        if(k==nr){
            for(int u=0;u<nr;u++){
                allr[u]+=need[i][u];
                need[i][u]=1000;
            }
            pr++;
        }
    }}
    if(pr==np){
        return true;
    }else{return false;}
}

int main(){
    int np,nr,ch,rr;
    cout<<"enter the no.of process\n";
    cin>>np;
    cout<<"enter no.of resources";
    cin>>nr;
    int alloc[np][nr],claim[np][nr],need[np][nr],dm[np][nr],ned[np][nr];
    int av[nr],allr[nr],rq[nr],fk[nr];
    cout<<"enter allocated matrix";
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            cout<<"enter alloc"<<np<<"::"<<nr<<" ";
            cin>>alloc[i][j];
        }
    }
   

    cout<<"enter claim matrix";
    for(int i=0;i<np;i++){
        for(int j=0;j<nr;j++){
            cout<<"enter claim"<<np<<"::"<<nr<<" ";
            cin>>claim[i][j];
            need[i][j]=claim[i][j]-alloc[i][j];
        }
    }
    for(int i=0;i<nr;i++){
        cout<<"enter total res for"<<nr<<" ";
        cin>>av[i];
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
    cc(alloc,dm,np,nr);
    while(ch){

        cout<<"enter 1 for new request,enter 0 to exit;\n";
        cin>>ch;
        if(ch==1){
            
            cout<<"enter process \n";
            cin>>p;
            cout<<"enter the resources\n";
            for(int i=0;i<nr;i++){
                cout<<"enter r"<<i<<" ";
                cin>>rq[i];
            }
            //check if > claim
            for(int i=0;i<nr;i++){
                if(!(claim[p][i]>=(alloc[p][i]+rq[i]))){
                    cout<<"requesting more than claimed";
                    rr=1;break;
                }
            }
            if(rr==1){
                continue;
            }rr=0;
            for(int i=0;i<nr;i++){
                if(!(allr[i]>=rq[i])){
                    cout<<"requesting more than available with sys";
                    rr=1;break;
                }
            }
            if(rr==1){
                continue;
            }rr=0;
            cc(need,ned,np,nr);
            for(int i=0;i<nr;i++){
                ned[p][i]-=rq[i];
                dm[p][i]+=rq[i];
                allr[i]-=rq[i];
            }
            if(chk(dm,ned,allr,p,np,nr)){
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

                if(uto==nr){
                    rem(need,claim,alloc,allr,p,nr);
                }else{
                    for(int i=0;i<nr;i++){
                        need[p][i]-=rq[i];
                    }
                }

                cc(dm,alloc,np,nr);
            }else{
                for(int i=0;i<nr;i++){
                    allr[i]+=rq[i];
                }
                cout<<"Not safe";
            }
       }
   }


    return 0;
}