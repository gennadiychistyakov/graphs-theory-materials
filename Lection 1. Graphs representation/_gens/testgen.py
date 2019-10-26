import os
import random

count = 30

os.system("javac GraphsGenerator.java")
for i in range(count):
	vertex, density = random.randint(400, 600), random.randint(400, 600) / 1000
	os.system("java GraphGenerator simplegraph " + str(vertex) + " " + str(density) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")