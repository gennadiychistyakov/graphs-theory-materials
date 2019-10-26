import os

data = [(10, 20, 5), (10, 40, 2), (20, 80, 19), (30, 60, 10), (100, 50, 7), (100, 350, 12), (100, 900, 1), (1000, 700, 100), (1000, 2200, 123), (1000, 15000, 1000)]

os.system("javac GraphsGenerator.java")
for i, j in enumerate(data):
	os.system("java GraphsGenerator simplegraphwv " + str(j[0]) + " " + str(j[1]) + " " + str(j[2]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")