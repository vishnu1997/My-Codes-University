package pkaccount;

public abstract class Account{
  protected int accnumber;
  protected double balance;

  public Account(){
    accnumber = 0;
    balance = 0;
  }
  public Account(int i,double d){
    accnumber = i;
    balance = d;
  }
}
