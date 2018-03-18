This object "Permutator" iterates through the Lexico-graphic permutations for the set of integers
[0...n-1] for a given n. Given the permutations of these integers, one can assosciate it with
a permutation of n Objects, if each object is considered to be given a unique id from 0 to (n-1).

Currently, the permutator will automatically start with the first Lexicographic permutation.
And to iterate to the next permutation, you must do perm.permutate();
So you must ensure that you only permutate (n! - 1) times to access all the Lexicographic
permutations.
(I plan to change it later so it works like an Iterator object)
