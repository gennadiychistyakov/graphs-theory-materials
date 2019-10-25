import os
import random

count = 3

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator2.java")
for i in range(count):
	#vertex, edge = 25, random.randint(50, 201)
	vertex, edge = 5, random.randint(6, 10)
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator2 " + str(vertex) + " " + str(edge) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator2.class")