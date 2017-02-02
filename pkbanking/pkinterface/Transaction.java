package pkinterface;

public interface Transaction {
  double min_balance = 500;
  void withdraw(double aes);
  void deposit(double asd);
}
