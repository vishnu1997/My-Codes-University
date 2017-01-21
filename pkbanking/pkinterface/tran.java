package pkinterface;

import java.io.*;

interface Transaction {
  double min_balance = 500;
  void withdraw(double aes);
  void deposit(double asd);
}

interface InterestRate{
  double sbrate = 4;
  double fdrate = 8.25;
}
