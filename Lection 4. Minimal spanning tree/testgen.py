import os
import random

count = 30

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i in range(count):
	vertex, edge = random.randint(9000, 9999), random.randint(50000, 300000)
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(vertex) + " " + str(edge) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")