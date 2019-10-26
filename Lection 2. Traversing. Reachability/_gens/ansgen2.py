import os

os.system("javac Solver2.java")

for root, dirs, files in os.walk(".", topdown = False):
	for f in files:
		if ".in" in f:
			os.system("java Solver2 < " + f + " > " + f[:-3] + ".out")	
	
os.system("del Solver2.class")