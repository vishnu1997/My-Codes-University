package shape2d;

import java.io.*;

public class Circle implements twod
{
 protected double radius;
 public Circle()
 {
  radius=0.00;
 }
 public Circle(double r)
 {
  radius=r;
 }
 public double area()
 {
  return 3.14*radius*radius;
 }
 public double perimeter()
 {
  return 2*3.14*radius;
 }
}
