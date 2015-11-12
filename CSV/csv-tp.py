import csv

with open('file.csv', 'w') as csvfile:
    fieldnames = ['first_name', 'last_name']
    
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
    writer.writerow({'first_name': 'John', 'last_name': 'Doe'})
    writer.writerow({'first_name': 'Samus', 'last_name': 'Aran'})
    writer.writerow({'first_name': 'Gordon', 'last_name': 'Freeman'})
