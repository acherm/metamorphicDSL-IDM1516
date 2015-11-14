from lxml import etree

# creation du fichier xml
root = etree.Element('book')
# auteur
child = etree.Element('author')
child.text = 'Neil Strauss'
root.append(child)

# titre
child = etree.Element('title')
child.text = 'The Game'
root.append(child)

# publisher
child = etree.Element('publisher')
child.text = 'Harpercollins'
root.append(child)

s = etree.tostring(root, pretty_print=True)
# Open a file
fo = open("book.xml", "wb")
fo.write(s);

# Close opend file
fo.close()
