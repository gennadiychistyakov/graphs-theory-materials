import os
import random

count = 30

os.system("javac TreeGenerator.java")
for i in range(count):
	vertex, query = 1000, 1000
	root = random.randint(1, vertex)
	os.system("java TreeGenerator " + str(vertex) + " " + str(root) + " " + str(query) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del TreeGenerator.class")