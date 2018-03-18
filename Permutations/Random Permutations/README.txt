This file offers algorithms that deal with permutations of lists of integers.
These are easily generalizable to lists of Objects, as one could simply assign unique id's
to each Object, and then permutate the id's.
To provide an idea of what applications these have, they will be described in relation to
groupings/orderings of students(as that was the original motivation for these algorithms).
It is important to keep in mind that in all of these algorithms NO ELEMENT IS EVER REPEATED
IN THE OUTPUT(unless there were multiple copies of it to begin with in the input).

The algorithms provided are:
-Randomly permutate an array of integers(in-place, or not). O(n) runtime
  So, if for instance a teacher wanted to generate a random ordering of students to present
  to the class, this would handle that.
-Randomly select a quantity of integers from an array
  If a teacher wanted to choose 5 students to attempt to answer a question each on a given
  day, this would randomly select 5 out of all the students, and put them in a unique order.
-Create random tuples between arrays of integers
  So for instance, if under some circumstances, two teams of students competed against each
  other by having one member from each team face of each other at a time, this would do that,
  by randomly assigning pairs with 1 member from each team.
-Create random groupings based on a format for a given array of integers
  Suppose that a teacher had 30 students in a classroom, and he/she wanted to randomly assign
  students such that there one group has 10 students, another has 7, then another has 12, and
  1 last student is by himself. The first input array would be the students, and the second
  input array, in this case, would be [10,7,12,1]
