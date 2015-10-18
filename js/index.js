 var graphviz = require('graphviz');

 var g = graphviz.digraph('gcd');

 g.addNode('a', {'label': 'start'});
 g.addNode('b', {'label': 'A = 0 or B = 0'});
 g.addNode('c', {'label': 'A = 0'});
 g.addNode('d', {'label': 'B = 0'});
 g.addNode('e', {'label': 'A >= B'});
 g.addNode('f', {'label': 'A = A - B'});
 g.addNode('g', {'label': 'swap A <-> B'});
 g.addNode('h', {'label': 'end'});

 g.addEdge('a', 'b');
 g.addEdge('b', 'c', {'label': 'Yes'});
 g.addEdge('b', 'd', {'label': 'No'});
 g.addEdge('d', 'e', {'label': 'No'});
 g.addEdge('e', 'f', {'label': 'Yes'});
 g.addEdge('f', 'e');
 g.addEdge('e', 'g', {'label': 'No'});
 g.addEdge('g', 'd');
 g.addEdge('d', 'h', {'label': 'Yes'});
 g.addEdge('c', 'h');

 g.output('png', 'gcd-js.png');
