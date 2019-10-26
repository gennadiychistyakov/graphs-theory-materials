import os

data = [(10, 20, 10), (10, 40, 10), (20, 80, 20), (30, 60, 20), (100, 50, 100), (100, 350, 300), (100, 900, 300), (1000, 700, 100), (1000, 2200, 1000), (1000, 15000, 5000)]

os.system("javac GraphsGenerator.java")
for i, j in enumerate(data):
	os.system("java GraphsGenerator simplegraphwsqw " + str(j[0]) + " " + str(j[1]) + " " + str(j[2]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")