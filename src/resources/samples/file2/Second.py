# A two dimensional GLP set 
# with n1=377,  n2=610
from matplotlib.matlab import *
def glp(n1, n2):
	q = zeros((2, n2), Float)
	h1 = 1; h2 = n1
	for i in arange(n2-1):
		q[0][ i] = (fmod(h1*(i+1), n2)-0.5)/n2
		q[1][ i] = (fmod(h2*(i+1), n2)-0.5)/n2
	q[0][n2-1] = (n2-0.5)/n2
	q[1][n2-1] = (n2-0.5)/n2
	return q
n1 = 377; n2 = 610
q = glp(n1, n2)
x = q[0, :]
y = q[1, :]
plot(x, y, 'r.', linewidth=2)
axis([0, 1, 0, 1])
title(r'$\rm{GLP \ set \ with} \ n_1 = 377, \ n_2 = 610$')
savefig('glp.png', dpi = 75)
show()