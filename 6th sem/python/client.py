#!/usr/bin/python           # This is client.py file

import socket               # Import socket module
import secrets


strin = str(secrets.randbits(128))
s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12345                # Reserve a port for your service.
s.connect((host, port))
print('key in this node is '+strin)

print(s.recv(1024).decode())
s.send(strin.encode())
s.close                     # Close the socket when done