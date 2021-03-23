This program uses what's called a "replacement grammar" to look through
a roman numeral and fix incorrect syntax. Through trial and error, a few
rules were discovered:

AAAA -> AB
BAB -> AC

Using these rules, we can express the pattern for replacing roman
numerals as follows, using 44 as an example:

// Repeating four characters is the wrong way to express a roman numeral.
44: XXXXIIII
// Here's the real roman numeral
44: XLIV

======================================

The above example proves the 'AAAA -> AB' rule. We can go further to 
prove 'BAB -> AC', using 19 as an example:

19: XVIIII
// This is wrong, so use the 'AAAA -> AB' rule:
19: XVIV

// The above representation is still wrong, since the symbol 'V' appears both 
// before and after 'I', making it impossible to actually represent its true value. 
// A symbol can only appear either before or after, not both.

// To fix the above representation, let's prove 'BAB -> AC':
19: XIX

======================================

The solution to this problem was thought up by my friend, Joe Smith.

The alternative solution was to use a lookup table and construct roman
numerals like that, but this was more fun to put together. The lookup table
solution is in the documentation folder.
