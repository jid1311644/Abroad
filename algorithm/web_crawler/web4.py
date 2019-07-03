import requests
import bs4
import mysql.connector

conn = mysql.connector.connect(user='root', password='1234', database='sys')
print('open database successfully')
cursor = conn.cursor()
op = "truncate table social"
cursor.execute(op)

class Acad:
    def __init__(self, id, name, country, overall, teaching, research, citations, industry, outlook):
        self.id = id
        self.name = name
        self.country = country
        self.overall = overall
        self.teaching = teaching
        self.research = research
        self.citations = citations
        self.industry = industry
        self.outlook = outlook
    def Output(self):
        print(self.id, self.name, self.country, self.overall, self.teaching, self.research, self.citations, self.industry, self.outlook, sep = ' ', end = '\n')
    def SavetoDB(self):
        op = "INSERT INTO social VALUES ('%d', '%s', '%s', '%f', '%f', '%f', '%f', '%f', '%f')" % (self.id, self.name, self.country, self.overall, self.teaching, self.research, self.citations, self.industry, self.outlook)
        cursor.execute(op)

url = 'http://rankings.betteredu.net/THE/2017-2018/social-sciences.html'

res = requests.get(url)
# print(res.text)
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl63')

Acad_arr = []
for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text
    country = soup1[index + 2].text
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    Acad_arr.append(Acad(id, name, country, overall, teaching, research, citations, industry, outlook))

print(len(Acad_arr))

for item in Acad_arr:
    item.SavetoDB()

conn.commit()
conn.close()
print('close database successfully')