import os

data = [(10, 4, 5), (10, 8, 5), (20, 15, 10), (30, 35, 10), (100, 50, 10), (100, 150, 10), (100, 300, 10), (1000, 700, 100), (1000, 1200, 100), (1000, 5000, 100)]

os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\javac.exe\" GraphGenerator.java")
for i, j in enumerate(data):
	os.system("\"c:\\Program Files\\Java\\jdk-12.0.2\\bin\\java.exe\" GraphGenerator " + str(j[0]) + " " + str(j[1]) + " " + str(j[2]) + " > " + ("0" + str(i + 1) + ".in")[-5:])
os.system("del GraphGenerator.class")