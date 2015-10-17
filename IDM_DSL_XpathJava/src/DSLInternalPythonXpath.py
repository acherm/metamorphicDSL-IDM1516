#!/usr/bin/env python
# -*- coding: utf-8 -*-

from lxml import etree


tree = etree.parse("./resources/etudiants.xml")
for etudiant in tree.xpath("/etudiants/etudiant[@id=4]/nom/text()"):
    print(etudiant.text)