__author__ = 'Monica Fernandez'


from elasticsearch import Elasticsearch
from elasticsearch_dsl import Search, Q

client = Elasticsearch()

s = Search() \
	.query("term", title="Example")   \
	.query("term", author="fracma")   \

print(s.to_dict())   

