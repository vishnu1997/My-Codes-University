package pkbanking.pkinterface;

public interface Transaction {
  public double min_balance = 500;
  void withdraw(double aes);
  void deposit(double asd);
}
