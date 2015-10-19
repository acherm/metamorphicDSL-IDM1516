#!/usr/bin/env python
# -*- coding: utf-8 -*-

from lxml import etree

tree = etree.parse("../resources/etudiants.xml")

#Nom de l'étudiant avec l'id 4
for etudiant in tree.xpath("/etudiants/etudiant[@id=4]/nom"):
    print("Nom étudiant avec l'id 4 : "+etudiant.text)
    
print("============================================================")
#Nom de l'étudiant avec l'id 4
print("Prénoms de tous les étudiants")
for etudiant in tree.xpath("/etudiants/etudiant/prenom"):
    print("Prénom : "+etudiant.text)