#!/usr/bin/python           # This is server.py file

import socket               # Import socket module
import secrets

strin = str(secrets.randbits(128))
s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12345                # Reserve a port for your service.
s.bind((host, port))        # Bind to the port
print('key in this node is '+strin)
s.listen(5)                 # Now wait for client connection.
c, addr = s.accept()     # Establish connection with client.
print ('Got connection from', addr)
c.send(strin.encode())
print(c.recv(1024).decode())

c.close()                # Close the connection