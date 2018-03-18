This is a program that can detect polynomial patterns from input. Or in fewer words:
Polynomial Interpolation
The unknown Function F, is assumed to be a polynomial, 
The input is given as integers that are outputs for F(0), F(1), F(2), F(3)... in
that order.
The program essentially computes the coefficients of the resulting polynomial, but
presents it in a readable manner.

So if a user were to input
1 4 9 16 25 36 49 64
The program would output x^2 + 2x + 1

The polynomial of the lowest degree that fits will be outputted. But at most the polynomial
will be of degree (n-1) if given n inputs.
This program could be done trivially were it to be turned into an augmented matrix and solved
with Reduced Row Echelon Form. However, the runtime complexity for solving a matrix is O(n^3).
The runtime complexity of the algorithm I've come up with is O(n^2)... My proof for this as
of yet unwritten, but can be described in person :P

