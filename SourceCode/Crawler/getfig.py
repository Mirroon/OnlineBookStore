import pymysql

db = pymysql.connect(host="47.106.241.204",
                    user="root",
                    passwd="onlinebookstore123",
                    db="OnlineBookStore")
cursor = db.cursor()
sql = "select cover from Book where(name='活着');"
cursor.execute(sql)
covers = cursor.fetchall()
index = 0
for cover in covers:
    fp = open('cover_'+'%05d.jpg' % index, "wb")
    fp.write(cover[0])
    fp.close()
    index+=1
cursor.close()
db.close()
