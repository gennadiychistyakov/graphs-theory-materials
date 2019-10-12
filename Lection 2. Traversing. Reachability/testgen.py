import os
import random

count = 30

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i in range(count):
	vertex, edge, query = random.randint(400, 600), random.randint(300, 700), random.randint(190, 210) 
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(vertex) + " " + str(edge) + " " + str(query) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")