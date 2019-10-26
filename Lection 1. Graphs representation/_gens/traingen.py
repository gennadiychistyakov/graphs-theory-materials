import os

data = [(10, .1), (10, .5), (20, .2), (30, .7), (100, .1), (100, .5), (100, .9), (1000, .1), (1000, .5), (1000, .9)]

os.system("javac GraphsGenerator.java")
for i, j in enumerate(data):
	os.system("java GraphsGenerator simplegraph " + str(j[0]) + " " + str(j[1]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphsGenerator.class")