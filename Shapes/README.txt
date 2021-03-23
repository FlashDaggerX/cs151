Here's... yet another overly-verbose solution to a simple problem.
It was really fun to put together, so I thought I'd write up another
document to explain the thought process behind it.

------------------------------------

The solution used in this problem was point-plotting, but not like
on a regular graph. Drawing graphics is different from drawing regular
shapes on a coordinate plane. Graphs on a screen usually look like this:

0 1 2 3 4 5 6 7 8 9
1 - - - - - - - - -
2 - - - - - - - - -
3 - - - - - - - - -
4 - - - - - - - - -

On top of that, the X coordinate isn't looked up first! Graphics drawing uses 
the Y coordinate to iterate through the avaiable points on a screen. To put it 
in more technical terms, a buffer of characters in this format would be 
accessed using:

buffer[y][x]

But you can solve this confusion. By creating a class that takes points in
the right order, all confusion is erased. That's what the "Buffer" class is
for; It hides away this confusing, evil thing.

-------------------------------------

Objects that can be rendered onto the buffer implement the "Drawable" interface,
which defines the function "draw()" and the default function "connect()" 

Each object that implements this interface must use draw() to return coordinates
for the buffer to render (Buffers themselves implement this interface too, actually).

connect() takes endpoints for lines and connects them in order, allowing for shapes
to be created with sides. It was actually really hard to come up with an algorithm for
line drawing, because it isn't a regular graph. Slope isn't helpful at all in this
situation, so what I decided to do was use "comparative integers" (you know, the numbers
returned from compareTo() in the "Comparable" interface). The result from comparing
each dimension in a Vector2 is added into a new Vector2 (see compareX() and compareY())
until both endpoints are equal.
