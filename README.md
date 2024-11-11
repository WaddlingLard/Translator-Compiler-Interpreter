# Homework #3: TA

* Author: Brian Wu
* Class: CS354 Section #001
* Semester: Fall 2023

## Overview

This is a translator that interprets in Java and compiles in C. It takes in various statements and 
is capable of multi-line statements.

## Reflection

This assignment was intimidating at first, but once part 1 was completed, the path was clear. Understanding
the code was what led to snowballing the assignment into completion. That and also spending a whole week, day in
day out, to work on it. Part 1 also made the workflow easy to understand and teach me how the grammar worked. I
think coding up the unary operator was the most important idea that I could transfer to part 2. It made 
creating nodes and understanding parse methods a lot easier. Creating a comment and allowing doubles was important, 
but it didn't provide the same amount of utility that I can apply to part 2. Documenting the code was also 
very useful. Even if I wasn't sure what to document at the time, it made me think about what the program was trying to do. Breaking down nodes and the parser wasn't easy, but it paid off.

Of all the homework assignments this is the most complete I've been so far, and it feels good. It was interesting 
and eye-opening to see both methods of executing code. One used a compiler in C and the other used plain old Java.
I wonder if there are other ways to compare the two methods using this program. If there was something I would tell 
younger me (around a month) when the assignment started it would probably be along the lines of, "remember to use
quotes." That would've saved so much of my sanity.

## Compiling and Using

To compile the code, using this command will set everything up:

javac *.java

Then to use, follow this format:

java Main "code block" "etc..."

Keep in mind to make sure the grammar is respected. Otherwise it'll throw errors and become angry.
Also, use quotes (I FORGOT ABOUT THEM).

## Results 

This program is in a 100% working state. The test suite should be more than enough to see each feature
work correctly. You could make tests more complex, but I felt these cover all bases of this assignment.
For example, the unary minus, commenting, and double features all work for part1, and part2 has all
of the new grammar working.

## Sources used

None
----------

## Notes

* This README template is using Markdown. Here is some help on using Markdown: 
[markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)


* Markdown can be edited and viewed natively in most IDEs such as Eclipse and VS Code. Just toggle
between the Markdown source and preview tabs.

* To preview your README.md output online, you can copy your file contents to a Markdown editor/previewer
such as [https://stackedit.io/editor](https://stackedit.io/editor).
