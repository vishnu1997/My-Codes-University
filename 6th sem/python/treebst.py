l=[]
l1=[]
l2=[]
class node:
  def __init__(self,da):
    self.data = da
    self.left = None
    self.right = None

class bst:
  def __init__(self):
    self.root = None
  
  def inse(self,nod,data):
    if(nod is None):
      va = node(data)
      nod = va
    elif nod.data<data:
      nod.right = self.inse(nod.right,data);
    else:
      nod.left = self.inse(nod.left,data)
    return nod
      
  def insert(self,data):
    self.root = self.inse(self.root,data)
    

   
  def show(self):
    self.sh(self.root)
  def sh(self,r):
    if r is not None:
      l.append(r.data)
      self.sh(r.left)
      self.sh(r.right)

  def show1(self):
      self.sh1(self.root)

  def sh1(self,r):
      if r is not None:
        self.sh1(r.left)
        l1.append(r.data)
        self.sh1(r.right)
  def show2(self):
      self.sh2(self.root)

  def sh2(self,r):
      if r is not None:
        
        self.sh2(r.right)
        l2.append(r.data)
        self.sh2(r.left)

tree = bst()
er = [5,3,8,1,4,6,9]
for i in range(len(er)):
  tree.insert(er[i])
tree.show1()
tree.show()
tree.show2()
print(l)
print(l1)
print(l2)