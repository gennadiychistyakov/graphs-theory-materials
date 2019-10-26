import os
import random

count = 30

os.system("javac GraphsGenerator.java")
for i in range(count):
	vertex, edge = random.randint(9000, 9999), random.randint(50000, 300000)
	os.system("java GraphsGenerator spanningtree " + str(vertex) + " " + str(edge) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")