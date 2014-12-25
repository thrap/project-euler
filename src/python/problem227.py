import numpy as np

n = 100/2+1
m = np.zeros([n, n])

def index(x):
    if x < 0:
        return -x
    elif x >= n:
        return n-1-(x-n+1)
    return x

for i in range(0, n):
    m[i][i] += 18
    m[i][index(i-1)] += 8
    m[i][index(i+1)] += 8
    m[i][index(i-2)] += 1
    m[i][index(i+2)] += 1

print sum(np.linalg.inv(np.identity(n-1)-(m[1:n, 1:n]/36))[n-2])
