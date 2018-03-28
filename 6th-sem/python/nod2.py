#!/usr/bin/python           # This is client.py file

import socket               # Import socket module

s = socket.socket()         # Create a socket object
s2 = socket.socket()
host = socket.gethostname() # Get local machine name
port = 12345
port2 = 12121                # Reserve a port for your service.
s.connect((host, port))
s2.bind((host,port2))


print(s.recv(1024).decode())
s.close()   
s2.listen(5)
c, addr = s2.accept()     
print ('Got connection12 from', addr)
c.send(b'Thank you for123 connecting')
c.close()
                  # Close the socket when done7                  cbcvvcbvcaaaaaaà