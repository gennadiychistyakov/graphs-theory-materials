import os

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" Solver1.java")

for root, dirs, files in os.walk(".", topdown = False):
	for f in files:
		if ".in" in f:
			os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" Solver1 < " + f + " > " + f[:-3] + ".out")	
	
os.system("del Solver1.class")