import pylab as pb
import numpy as np
import GPy
import scipy as sc
pb.ion()
pb.close('all')

X = np.genfromtxt('features', delimiter=',')
#print X
#X1 = np.genfromtxt('features/all-smt1.gb_features', delimiter='\t')
#X2 = np.genfromtxt('features/all-smt2.bb_features', delimiter='\t')
#X3 = np.genfromtxt('features/all-smt1.gb_features', delimiter='\t')


Y = np.genfromtxt('index_test_samples', dtype=int) # .reshape(-1,1)
#print Y

#selected = sort_ls[0:i];
#test = X[:,Y-1];
test = X[Y-1,:];
train = sc.delete(X,Y-1,0)
#test.tofile('test2.out', sep=",")
np.savetxt('test_all', test, delimiter=',') #, newline='\n')
np.savetxt('train_all', train, delimiter=',') #, newline='\n')
#np.save('outfile', test)
#print test

