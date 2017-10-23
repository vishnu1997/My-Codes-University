package shape2d;

import java.io.*;

public class Square implements twod
{
 protected double side;
 public Square()
 {
  side=0.00;
 }
 public Square(double s)
 {
  side=s;
 }
 public double area()
 {
  return side*side;
 }
 public double perimeter()
 {
  return 4*side;
 }
}
