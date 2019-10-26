import os

os.system("javac Solver1.java")

for root, dirs, files in os.walk(".", topdown = False):
	for f in files:
		if ".in" in f:
			os.system("java Solver1 < " + f + " > " + f[:-3] + ".out")	
	
os.system("del Solver1.class")