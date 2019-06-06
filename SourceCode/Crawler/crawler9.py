import requests                    
from bs4 import BeautifulSoup        
import time          
import re            
import pymysql       
import random        
import requests
import pymysql
import time, timeit
 
def clock(func):
    def clocked(*args, **kwargs):
        t0 = timeit.default_timer()
        result = func(*args, **kwargs)
        elapsed = timeit.default_timer() - t0
        name = func.__name__
        arg_str = ', '.join(repr(arg) for arg in args)
        # print('[%0.8fs] %s(%s) -> %r' % (elapsed, name, arg_str, result))
        print('[%0.3fs] %s(%s) -> %r' % (elapsed, name, args[0], result))
        return result
    return clocked

Headers = []
Headers.append({
    'User-Agent':'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)',
    'Referer':'http://www.xbiquge.la'
})
Headers.append({
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36',
    'Referer':'http://www.xbiquge.la'
})
Headers.append({
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36',
    'Referer':'https://search.chongbuluo.com/'
})
Headers.append({
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36',
    'Referer':'https://www.123du.cc/'
})

def get_tag_url():
    url="https://book.douban.com/tag/?icn=index-nav"
    wb_data=requests.get(url,headers = Headers[random.randint(0, 3)])
    soup=BeautifulSoup(wb_data.text,"lxml")
    tags=soup.select("#content > div > div.article > div > div > table > tbody > tr > td > a")
    tag_url=[] 
    for tag in tags:    
        tag=tag.get_text()
        helf="https://book.douban.com/tag/"   
        tag_url.append(helf+str(tag))  
    return tag_url

def get_subject_url(url,db):
    page_url=['?start=20&type=T','?start=40&type=T','?start=60&type=T','?start=80&type=T']
    for page in page_url:
        pageurl = url+page
        try:
            wb_data = requests.get(pageurl,headers = Headers[random.randint(0, 3)])
            soup=BeautifulSoup(wb_data.text,"lxml")
            subjects=soup.select("#subject_list > ul > li > div.pic > a")
            for subject in subjects:
                subject_url=subject.attrs['href']
                subject_cover_src=subject.contents[1].attrs['src']
                # print(subject_url)
                get_subject(subject_url,subject_cover_src,db)
        except:
            print(pageurl+"\tfault")
            pass


def dill_price(price):
    price = price.strip()
    if re.match("USD", price):      
        price = re.findall(r"\d+\.?\d*",price)[0]
        price = round(float(price),2)
        price = price *6.9
    elif re.match("\A$", price):       
        price = re.findall(r"\d+\.?\d*",price)[0]
        price = round(float(price),2)
        price = price *6.9
    else:       
        price = re.findall(r"\d+\.?\d*",price)[0]
        price = round(float(price),2)
    return price

@clock
def get_subject(url,subject_cover_src,db):
    time.sleep(random.uniform(3.1,10.4))
    try:
        wb_data = requests.get(url,headers = Headers[random.randint(0, 3)])
        soup=BeautifulSoup(wb_data.text,"lxml")
        name = soup.select("#wrapper > h1 > span")[0].text
        ISBN,author,translator,publisher,publish_date,price = get_subject_detials(soup)
        book_intro,author_intro,content = get_subject_intro(soup)
        cover = get_cover(subject_cover_src)
        tags = get_subject_tag(soup)
        print(ISBN+'  '+name+'  '+author+'  '+translator+'  '+publisher+'  '+publish_date+'  '+str(price))
        print(tags)
        # print(cover)
        # print(book_intro)
        # print(author_intro)
        # print(content)
        # 使用cursor()方法获取操作游标 
        cursor = db.cursor()
        # SQL 插入语句
        sql1 = "INSERT INTO Book(ISBN, name, author, translator, publisher, publish_date, price, cover, book_intro, auth_intro, content) VALUES (%s, %s,  %s,  %s,  %s,  %s, %s, %s,%s, %s,  %s); "
        sql2 = "INSERT INTO Book_Tag(ISBN,tag)VALUES (%s, %s); "
        try:
            # 执行sql语句
            cursor.execute(sql1, (ISBN, name, author, translator, publisher, publish_date, price,
                                cover, book_intro, author_intro, content))
            for tag in tags:
                cursor.execute(sql2,(ISBN,tag))
            # 提交到数据库执行
            db.commit()
        except Exception as e:
            print(e)
            print("database falut")
            db.rollback()
        # 关闭游标
        cursor.close()

        return("Done!")
    except:
        return("Fault")

def get_subject_detials(soup):
    ISBN=''
    author=''
    translator=''
    publisher=''
    publish_date=''
    price=0.0
    detials=soup.select("#info > span")
    for detial in detials:
        if detial.next =='\n':
            text = detial.select("span")[0].text
            if(text == " 作者"):
                author = detial.select("a")[0].text.strip()
            elif(text == " 译者"):
                translator = detial.select("a")[0].text.strip()
        elif detial.text =='作者:':
            if detial.next_sibling == '\xa0\n        ':
                author = soup.select("#info > a")[0].text.replace('\n','').replace(' ','')
            else:
                author = detial.next_sibling.strip()
        elif detial.text =='出版社:':
            publisher = detial.next_sibling.strip()
        elif detial.text =='ISBN:':
            ISBN = detial.next_sibling.strip()
        elif detial.text =='出版年:':
            publish_date = detial.next_sibling.strip()
        elif detial.text =='定价:':
            price = dill_price(detial.next_sibling)
    return ISBN,author,translator,publisher,publish_date,price

def get_subject_intro(soup):
    book_intro=''
    author_intro=''
    content=''
    link_report = soup.select("#link-report")
    try:
        paras=link_report[0].select("div > div.intro")[-1].select("p")
        for para in paras:
            book_intro+='\n'
            book_intro+=para.text
    except:
        pass
    try:
        paras=soup.select("div.intro")[-1].select("p")
        for para in paras:
            author_intro+='\n'
            author_intro+=para.text
    except:
        pass
    try:
        paras=soup.select("div.indent[id^='dir']")[-1]
        content=paras.text
        content=content.rstrip(content[-5:])
    except:
        pass
    return book_intro,author_intro,content

def get_subject_tag(soup):
    tags=[]
    tags_span = soup.select("#db-tags-section >div.indent>span")
    for span in tags_span:
        text = span.text.replace('\n','').replace(' \xa0    ','')
        tags.append(text)
    return tags

def get_cover(src):
    pic = requests.get(src)
    return pic.content


if __name__ == "__main__":
    tag_urls = get_tag_url()

    for tag in tag_urls[9:36]:
        print(tag)
        # 打开数据库连接
        db = pymysql.connect(   host="47.106.241.204",
                            user="root",
                            passwd="onlinebookstore123",
                            db="OnlineBookStore" )
        try:
            get_subject_url(tag,db)
        finally:
            db.close()
    
    
