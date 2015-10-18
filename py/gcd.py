#!/usr/bin/env python3
from graphviz import Digraph

dot = Digraph(format='png')

dot.node('a', 'start')
dot.node('b', 'A = 0 or B = 0')
dot.node('c', 'A = 0')
dot.node('d', 'B = 0')
dot.node('e', 'A >= B')
dot.node('f', 'A = A - B')
dot.node('g', 'swap A <-> B')
dot.node('h', 'end')

dot.edge('a', 'b')
dot.edge('b', 'c', label='Yes')
dot.edge('b', 'd', label='No')
dot.edge('d', 'e', label='No')
dot.edge('e', 'f', label='Yes')
dot.edge('f', 'e')
dot.edge('e', 'g', label='No')
dot.edge('g', 'd')
dot.edge('d', 'h', label='Yes')
dot.edge('c', 'h')

dot.render('graph-gcd')
