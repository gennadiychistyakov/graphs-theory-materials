import os
import random

count = 30

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i in range(count):
	vertex, density = random.randint(400, 600), random.randint(400, 600) / 1000
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(vertex) + " " + str(density) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")