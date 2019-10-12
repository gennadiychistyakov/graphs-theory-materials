import os
import random

count = 30

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i in range(count):
	vertex, edge, v, k = 1000, random.randint(20000, 35000), random.randint(1, 1000), random.randint(100, 300)
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(vertex) + " " + str(edge) + " " + str(v) + " " + str(k) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")