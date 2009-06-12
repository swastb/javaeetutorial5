import urllib.request
url = r"http://www.exfer.net/jquery/createjQueryXMLDocs.py?version=1.3"
path = r"jQueryXMLDocs.xml"
data = urllib.request.urlretrieve(url,path)
