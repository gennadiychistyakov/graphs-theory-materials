import os

data = [(10, .1), (10, .5), (20, .2), (30, .7), (100, .1), (100, .5), (100, .9), (1000, .1), (1000, .5), (1000, .9)]

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i, j in enumerate(data):
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(j[0]) + " " + str(j[1]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")