class Node:
  def __init__(self,data):
    self.data=data
    self.next=None
    
class Linked_List:
  def __init__(self):
    self.head=None
  def push(self,data):
    new_node=Node(data)
    new_node.next=self.head
    self.head=new_node
  def last(self,data):
    new_node = Node(data)
    if self.head==None:
      self.head=new_node
      return
    temp = self.head
    while(temp.next):
      temp=temp.next
    temp.next=new_node
  def show(self):
    s=""
    temp=self.head
    while(temp):
      s+=str(temp.data)+" "
      temp=temp.next
    print(s)
      
link_list = Linked_List()
n = int(input())
l = list(map(int,input().split()))
fl=True
va=0
for jk in range(len(l)):
  if(fl):
    va=l[jk]
    fl=False
    continue
  if(l[jk]==0):
    link_list.push(va)
  else:
    link_list.last(va)
  fl=True
  
link_list.show()
   
