import pymysql

db = pymysql.connect(host="47.106.241.204",
                    user="root",
                    passwd="onlinebookstore123",
                    db="OnlineBookStore")
cursor = db.cursor()
sql = "select ISBN, cover from Book;"
cursor.execute(sql)
covers = cursor.fetchall()
for cover in covers:
    fp = open('./images/'+cover[0]+'.jpg', "wb")
    fp.write(cover[1])
    fp.close()
cursor.close()
db.close()
