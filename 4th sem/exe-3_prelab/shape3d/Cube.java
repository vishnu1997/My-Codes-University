package shape3d;

import java.io.*;
import shape2d.*;

public class Cube extends Square implements threed
{
 public Cube()
 {
  super();
 }
 public Cube(double s)
 {
  super(s);
 }
 public double volume()
 {
  return side*side*side;
 }
 public double surfaceArea()
 {
  return 6*side;
 }
}
