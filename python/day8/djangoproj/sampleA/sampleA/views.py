from django.http import HttpResponse
from django.shortcuts import render

def niit(requests):
    return HttpResponse('<h1> hello world </h1>')

def home(requests):
    return render(requests, 'home.html',{'city':['hyderabad','blr'] , 'comapny':'deloitte'})


def count(requests):
    return render(requests, 'count.html')

def home1(requests):
    return render(requests, 'home1.html')

def count1(requests):
    data=requests.GET['fulltext']
    listw = data.split()
    wordict={}
    for w in listw:
        if w in wordict:
            wordict[w] +=1
        else:
            wordict[w]=1

    l=sorted(wordict.items(), key = lambda kv:(kv[1], kv[0]),reverse=True)
    return render(requests,'count1.html',{'dataone':data,'len':len(listw),'wordict':wordict,'l':l,'wordict1':wordict.items()})
