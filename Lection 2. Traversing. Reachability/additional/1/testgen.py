import os
import random

count = 30

os.system("javac GraphsGenerator.java")
for i in range(count):
	vertex, edge, v, k = 1000, random.randint(20000, 35000), random.randint(1, 1000), random.randint(100, 300)
	os.system("java GraphGenerator simplegraphreach " + str(vertex) + " " + str(edge) + " " + str(v) + " " + str(k) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")