#!/usr/bin/python           # This is client.py file

import socket               # Import socket module
import secrets


strin = str(secrets.randbits(8))
s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12345                # Reserve a port for your service.
s.connect((host, port))
print('\nthe id is '+strin)

re = str(s.recv(1024).decode())
re+=strin
print(re)
s.send(re.encode())

rr=(s.recv(1024).decode())
print("\ndata received::"+rr)
tr=rr.find(strin)
tt = rr[:tr]
print("\n data after decryption ::"+tt)
s.close                     # Close the socket when done