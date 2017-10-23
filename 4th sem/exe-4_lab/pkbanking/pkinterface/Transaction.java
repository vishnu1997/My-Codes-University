package pkbanking.pkinterface;

import pkbanking.pkexception.*;

public interface Transaction {
  public double min_balance = 500;
  void withdraw(double aes)throws InsufficientFundsException;
  void deposit(double asd)throws IllegalArgumentException;
}
