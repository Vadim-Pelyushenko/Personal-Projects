What we have here is a SetSelector object, and a Selection object.

Selection describes a... selection of objects, with a quantity assosciated to each.
so a Selection may for instance, describe a selection of 7 Red Balls, 4 Green Balls, and 5 Yellow Balls.
In which case you may create a Selection of that like so

Balls[] ba = {new Ball("Red"),new Ball("Green"),new Ball("Yellow")};
int[] qua = {7,4,5};
Selection<Ball> select = new Selection<Ball>(ba,qua);

What SetSelector does, is it allows you to iterate over all possible selections within a given set
with quantities. So the following would allow you to iterate through all possible selections

Balls[] ba = {new Ball("Red"),new Ball("Green"),new Ball("Yellow")};
int[] qua = {7,4,5};
SetSelector<Selection<Ball>> setSel = new SetSelector<Selection<Ball>>(ba,qua);
Iterator<Selection> iter = setSel.iterator();

while(iter.hasNext())
{
  Selection sel = iter.next();
  // Your code here to do something with this selection
}

An example usage of SetSelector is included in this directory.
