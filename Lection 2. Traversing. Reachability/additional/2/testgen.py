import os
import random

count = 30

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i in range(count):
	vertex, query = 1000, 1000
	root = random.randint(1, vertex)
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(vertex) + " " + str(root) + " " + str(query) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")