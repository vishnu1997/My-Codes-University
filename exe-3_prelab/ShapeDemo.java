import java.io.*;
import shape2d.*;
import shape3d.*;
public class ShapeDemo
{
 public static void main(String args[])
 {
  Square sq=new Square(4);
  Rectangle r=new Rectangle(5,6);
  Circle cir=new Circle(3);
  Cube cub=new Cube(5);
  Cuboid cubo=new Cuboid(4,5,6);
  Sphere sph=new Sphere(7);
  System.out.println("Area of the square= "+sq.area());
  System.out.println("Perimeter of the square= "+sq.perimeter());
  System.out.println("Area of the rectangle= "+r.area());
  System.out.println("Perimeter of the rectangle= "+r.perimeter());
  System.out.println("Area of the circle= "+cir.area());
  System.out.println("Perimter of the circle= "+cir.perimeter());
  System.out.println("Volume of the cube= "+cub.volume());
  System.out.println("Surface Area of the cube= "+cub.surfaceArea());
  System.out.println("Volume of the cuboid= "+cubo.volume());
  System.out.println("Surface Area of the cuboid= "+cubo.surfaceArea());
  System.out.println("Volume of the sphere= "+sph.volume());
  System.out.println("Surface Area of the sphere= "+sph.surfaceArea());
 }
}
