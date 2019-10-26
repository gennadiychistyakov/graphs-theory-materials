import os

data = [(1000, 0.3), (1000, 0.6), (1000, 0.8)]

os.system("javac GraphsGenerator.java")
for i, j in enumerate(data):
	os.system("java GraphsGenerator simplegraph " + str(j[0]) + " " + str(j[1]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")