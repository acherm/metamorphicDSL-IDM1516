#!/bin/sh

cat exemple.txt | while  read ligne ; do
	echo $ligne | sed -e 's/[a-zA-Z]//g'
done
