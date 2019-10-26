import os

data = [(5, 6), (10, 20), (10, 30), (20, 80), (30, 100), (100, 150), (100, 200), (100, 400), (1000, 100000), (1000, 200000)]

os.system("javac CyclesGenerator.java")
for i, j in enumerate(data):
	os.system("java CyclesGenerator eulergraph " + str(j[0]) + " " + str(j[1]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del CyclesGenerator.class")
os.system("del CyclesGenerator$Pair.class")