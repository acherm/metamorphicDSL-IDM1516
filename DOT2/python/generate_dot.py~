import graphviz as gv

g1 = gv.Graph(format='svg')

""" Nodes """
g1.node('top')
g1.node('v1')
g1.node('v2')
g1.node('v3')
g1.node('v4')
g1.node('v5')
g1.node('bottom')

""" Edges """
g1.edge('top', 'v1')
g1.edge('top', 'v3')
g1.edge('top', 'v4')
g1.edge('v1', 'v2')
g1.edge('v2', 'bottom')
g1.edge('v3', 'v5')
g1.edge('v4', 'v5')
g1.edge('v5', 'bottom')

print(g1.source)
