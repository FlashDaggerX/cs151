#!/bin/python

NUMERALS = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
NUM_DIVS = [1000, 500, 100, 50, 10, 5, 1]

def strip_last_digit(x):
    return x // 10

def get_last_digit(x):
    return int(x % 10)

def places(n):
    pos = []
    while n > 0:
        pos.append(get_last_digit(n))
        n = strip_last_digit(n)
    return pos

from math import log10, ceil
def length(n):
    return ceil(log10(n))

# n is a list of number places (ex 2352 = [2, 5, 3, 2] [ones, tens, ...])
def roman(n):
    roman_numeral = ''

    roman_pool = NUMERALS[::-1]
    roman_pool_place = 0

    n_place = 0

    # start in the ones place
    # the number has two conditions:
    #   if it's more than III, use IV
    #   if it's more than VIII, use IX
    for i in n:
        # Range 0-3
        if i <= 3:
            pass
        # Range (3-5]
        elif i <= 5:
            pass
        # Range (5, 9]
        elif i <= 9:
            pass
