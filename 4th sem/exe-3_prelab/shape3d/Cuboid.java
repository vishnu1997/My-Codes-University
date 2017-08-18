package shape3d;

import java.io.*;
import shape2d.*;

public class Cuboid extends Rectangle implements threed
{
 protected double height;
 public Cuboid()
 {
  super();
  height=0.00;
 }
 public Cuboid(double l, double b, double h)
 {
  super(l,b);
  height=h;
 }
 public double volume()
 {
  return length*breadth*height;
 }
 public double surfaceArea()
 {
  return 2*(length*breadth+breadth*height+length*height);
 }
}
