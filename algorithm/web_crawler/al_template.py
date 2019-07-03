import sys

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
    def to_arr(self):
        arr = []
        return arr

class User:
    def __init__(self, name, age, sex, grade, wealth, toward):
        self.name = name
        self.age = age
        self.sex = sex
        self.grade = grade
        self.wealth = wealth
        self.toward = toward
    def to_arr(self):
        arr = []
        return arr

def commend(arr1, arr2):
    result = 0
    if len(arr1) == 0 or len(arr2) == 0:
        return 0
    for i in range(len(arr1)):
        count = arr1[i] ** arr2[i]
        result += count
    return result