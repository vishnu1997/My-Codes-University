// ichar2.cpp
// file input with characters
#include <fstream>                //for file functions
#include <iostream>
#include<string>
using namespace std;

int main()
   {
   ifstream infile("test.txt");   //create file for input

   cout<<infile.rdbuf();        //send its buffer to cout
       cout << endl;
   return 0;
   }
