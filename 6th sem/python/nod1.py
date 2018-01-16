#!/usr/bin/python           # This is server.py file

import socket               # Import socket module

s = socket.socket()
s2 = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12345 
port2 = 12121               # Reserve a port for your service.
s.bind((host, port)) 
s2.connect((host, port2))       # Bind to the port

s.listen(5)                 # Now wait for client connection.
c, addr = s.accept()     # Establish connection with client.
print ('Got connection from', addr)
c.send(b'Thank you for connecting')
c.close()                # Close the connection
print(s2.recv(1024).decode())
s2.close()