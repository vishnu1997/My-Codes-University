package shape3d;

import shape2d;
import java.io.*;
import java.util.*;

//------------------------------interface threed
interface threed{

	//--------------------------volume
	double volume();

	//--------------------------surface area
	double surfaceArea();
}

//-------------------------------class cube
class Cube extends Square implements threed{

	//--------------------------constructor
	Cube(double b){
		super(b);
	}

	//--------------------------volume
	double volume(){
		return (side*side*side);
	}

	//--------------------------surface area
	double surfaceArea(){
		return (6*side*side);
	}
}

//-------------------------------class sphere
class Cuboid extends Rectangle implements threed{

	double height;

	//--------------------------constructor
	Cuboid(double len,double bdth,double hgt){
		super(len,bdth);
		height = hgt;
	}

	//--------------------------volume
	double volume(){
		return (length*breadth*height);
	}

	//--------------------------surface area
	double surfaceArea(){
		return (2*(length*breadth+breadth*height+height*lenght));
	}
}
//-------------------------------class Sphere
class Sphere extends Circle implements threed{

	//--------------------------constructor
	Sphere(double a){
		super(a);
	}

	//--------------------------volume
	double volume(){
	return ((4/3)*3.14*radius*radius*radius);
	}

	//--------------------------surface area
	double surfaceArea(){
		return(4*3.14*radius*radius);
	}
}
