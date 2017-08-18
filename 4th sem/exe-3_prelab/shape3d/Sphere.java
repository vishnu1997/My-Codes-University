package shape3d;

import java.io.*;
import shape2d.*;

public class Sphere extends Circle implements threed
{
 public Sphere(double a)
 {
  super(a);
 }
 public double volume()
 {
  return 3.14*radius*radius*radius;
 }
 public double surfaceArea()
 {
  return 2*3.14*radius*radius;
 }
}
