#include<iostream> 
using namespace std; 
class Base{ 
public:
    int func()
     {
      cout << "Base::func() called";
     }
   int func(int i)
{
 cout << "Base::func(int i) called"; }
};
class Derived: public Base
{
public:
  int func(char x)
{
 cout << "Derived::func(char ) called"<<x; }
};


int main() { 
    Derived d;
    d.func(65);
    return 0;
}
