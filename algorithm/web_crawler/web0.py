import random
import requests
import bs4
import mysql.connector

conn = mysql.connector.connect(user='root', password='1234', database='sys')
print('open database successfully')
cursor = conn.cursor()
op = "truncate table summaryplus"
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
        self.tag = [-1, -1, -1, -1, -1, -1]
        self.type = 'private' if random.randint(1, 100) % 19 == 0 else 'public'
        self.netprice = 8000 + random.randint(0, 5000) + random.randint(11, 45) ** 2
        self.passrate = min((id ** 0.5), 20) * 0.01 + random.random() * 0.1 + 0.04
        self.students = 12000 + random.randint(0, 15000) + random.randint(37, 91) ** 2
        self.gradrate = 0.7 + random.random() * 0.1 + (random.random() ** 0.5) * 0.15
    def Output(self):
        print(self.id, self.name, self.country, self.overall, self.teaching, self.research, self.citations, self.industry, self.outlook, self.tag, sep = ' ', end = '\n')
        print(self.type, self.netprice, self.passrate, self.students, self.gradrate)
    def SavetoDB(self):
        op = "INSERT INTO summaryplus VALUES ('%d', '%s', '%s', '%f', '%f', '%f', '%f', '%f', '%f', '%d', '%d', '%d', '%d', '%d', '%d', '%s', '%d', '%f', '%d', '%f')" % (self.id, self.name, self.country, self.overall, self.teaching, self.research, self.citations, self.industry, self.outlook, self.tag[0], self.tag[1], self.tag[2], self.tag[3], self.tag[4], self.tag[5], self.type, self.netprice, self.passrate, self.students, self.gradrate)
        cursor.execute(op)

url = []
url.append('http://www.betteredu.net/rankings/THE/2018-2019/top-1000.html')
url.append('http://rankings.betteredu.net/THE/2017-2018/engineering-and-IT.html')
url.append('http://rankings.betteredu.net/THE/2017-2018/clinical-health.html')
url.append('http://rankings.betteredu.net/THE/2017-2018/social-sciences.html')
url.append('http://rankings.betteredu.net/THE/2017-2018/life-sciences.html')
url.append('http://rankings.betteredu.net/THE/2017-2018/physical-sciences.html')
url.append('http://rankings.betteredu.net/THE/2017-2018/arts-and-humanities.html')

Acad_arr = []
def locate(name):
    for item in Acad_arr:
        if item.name == name:
            return item.id
    return -1

res = requests.get(url[0])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl64')

for i in range(1, len(soup1) // 9):
    index = i * 9
    id = i
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    Acad_arr.append(Acad(id, name, country, overall, teaching, research, citations, industry, outlook))

for k in range(0, 100):
    Acad_arr[k].Output()

res = requests.get(url[1])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl65')

for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    change_id = locate(name)
    print(name, change_id, sep = ',')
    if change_id != -1:
        Acad_arr[change_id - 1].tag[0] = id

res = requests.get(url[2])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl64')

for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    change_id = locate(name)
    print(name, change_id, sep = ',')
    if change_id != -1:
        Acad_arr[change_id - 1].tag[1] = id

res = requests.get(url[3])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl63')

for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    change_id = locate(name)
    print(name, change_id, sep = ',')
    if change_id != -1:
        Acad_arr[change_id - 1].tag[2] = id

res = requests.get(url[4])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl64')

for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    change_id = locate(name)
    print(name, change_id, sep = ',')
    if change_id != -1:
        Acad_arr[change_id - 1].tag[3] = id

res = requests.get(url[5])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl64')

for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    change_id = locate(name)
    print(name, change_id, sep = ',')
    if change_id != -1:
        Acad_arr[change_id - 1].tag[4] = id

res = requests.get(url[6])
soup = bs4.BeautifulSoup(res.text, 'html.parser')
soup1 = soup.select('.xl63')

for i in range(0, len(soup1) // 9):
    index = i * 9
    id = i + 1
    name = soup1[index + 1].text.replace("\'", "")
    country = soup1[index + 2].text.replace("\'", "")
    overall = float(soup1[index + 3].text.split('–')[0])
    teaching = float(soup1[index + 4].text.split('–')[0])
    research = float(soup1[index + 5].text.split('–')[0])
    citations = float(soup1[index + 6].text.split('–')[0])
    industry = float(soup1[index + 7].text.split('–')[0])
    outlook = float(soup1[index + 8].text.split('–')[0])
    change_id = locate(name)
    print(name, change_id, sep = ',')
    if change_id != -1:
        Acad_arr[change_id - 1].tag[5] = id

# for k in range(0, 100):
#     Acad_arr[k].Output()

print(len(Acad_arr))
for item in Acad_arr:
    item.SavetoDB()

conn.commit()
conn.close()
print('close database successfully')