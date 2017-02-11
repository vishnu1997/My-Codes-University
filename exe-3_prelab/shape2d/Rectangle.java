package shape2d;

import java.io.*;

public class Rectangle implements twod
{
 protected double length;
 protected double breadth;
 public Rectangle()
 {
  length=0.00;
  breadth=0.00;
 }
 public Rectangle(double l, double b)
 {
  length=l;
  breadth=b;
 }
 public double area()
 {
  return length*breadth;
 }
 public double perimeter()
 {
  return 2*length*breadth;
 }
}
