import os

data = [(10, 20), (10, 40), (20, 80), (30, 25), (100, 90), (100, 180), (100, 200), (1000, 700), (1000, 1500), (1000, 2500)]

os.system("javac GraphsGenerator.java")
for i, j in enumerate(data):
	os.system("java GraphGenerator simplegraphwpnw " + str(j[0]) + " " + str(j[1]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")