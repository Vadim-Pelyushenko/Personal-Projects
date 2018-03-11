An ancient, easy to understand Sieve that finds all the prime numbers up to a point.
https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

As of my writing this(March 10th 2018), this is the only Sieve that I've made and used.

The Sieve coded here is made as an Object. It has two different constructors:
-One which takes in a long val, and generates all the prime numbers necessary to be able to
create the prime factorization of numbers less than or equal to the input val.
-One which takes in an int val and a boolean getAllPrimes. If getAllPrimes is false, then
the Sieve will do exactly the same as above. Otherwise it will create a Sieve which gets
all primes numbers less than or equal to the input val.

Features of the Sieve in addition to simply providing the list of primes:

-The Sieve can tell you if an input is prime or not.

-The Sieve can expand the range of primes it holds. So, if you write the following code
Sieve s = new Sieve(1000000,true);
s.expandSieve(1000000);
You will have a sieve that has stored all the prime numbers from 2 to 2 million

-The Sieve can provide the prime factorization of an input. Te prime factorization will be
provided as an ArrayList of Factor(describes the factor, and the power of the factor).

-The Sieve can give a list of all the proper divisors of an input. This will be returned
as an ArrayList of Long.
