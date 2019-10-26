import os
import random

count = 30

os.system("javac GraphsGenerator.java")
for i in range(count):
	vertex, edge, query = random.randint(400, 600), random.randint(300, 700), random.randint(190, 210) 
	os.system("java GraphsGenerator simplegraphwsq " + str(vertex) + " " + str(edge) + " " + str(query) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")