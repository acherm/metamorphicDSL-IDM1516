local cassandra = require "cassandra"

local session = cassandra.new()
session:set_timeout(1000)

local connected, err = session:connect("127.0.0.1", 9042)


session:set_keyspace("MyKeySpace")

print ("Connected: ")
print (connected)

local batch = cassandra.BatchStatement()

-- Table creation

local table_created, err = session:execute [[
  CREATE TABLE MyColumns(
    id text,
    Last text,
    First text,
    PRIMARY KEY(id)
  )
]]

print (err)

-- Table insertion

batch:add("INSERT INTO MyColumns (id, Last, First) VALUES (?, ?, ?)",
          {'1', 'Doe', 'John'})

local result, err = session:execute(batch)

-- Table query

local query = "SELECT * FROM MyColumns"

local rows, err = session:execute(query, nil, {page_size = 500})

print ("First: " .. rows[1].first)
print ("Last: " .. rows[1].last)
