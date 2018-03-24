#!/usr/bin/python           # This is server.py file

import socket               # Import socket module
import secrets
import hashlib


strin = str(secrets.randbits(64))
s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12345                # Reserve a port for your service.
s.bind((host, port))        # Bind to the port
print('\n key in this node is '+strin)
s.listen(5)                 # Now wait for client connection.
c, addr = s.accept()     # Establish connection with client.
print ('Got connection from', addr)
c.send(strin.encode())
v = str(c.recv(1024).decode())
pas = input("enter message")

if(v.find(strin)==0):
    print("\nid correct")
    le = len(strin)
    id = v[:le]
    me = v[le:]
    pas+=me
    #hashlib.sha1(pas.encode('utf-8')).hexdigest()
    t = pas.encode()
    print("\nmes sent::"+pas)
    c.send(t)

c.close()                # Close the connection