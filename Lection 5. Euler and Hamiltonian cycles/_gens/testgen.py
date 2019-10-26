import os
import random

count = 30

os.system("javac CyclesGenerator.java")
for i in range(count):
	vertex, edge = 25, random.randint(50, 201)
	os.system("java CyclesGenerator hamiltoniangraph " + str(vertex) + " " + str(edge) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del CyclesGenerator.class")
os.system("del CyclesGenerator$Pair.class")