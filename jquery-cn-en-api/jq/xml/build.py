from xml.dom import minidom
import codecs,os,shutil
xmldoc = minidom.parse('jqueryapi.xml')
targetdir="build"
hhc="C:\Program Files\HTML Help Workshop\hhc.exe"
print("正在创建"+targetdir)

if os.path.exists(targetdir):
	print("正在删除现有的"+targetdir)
	shutil.rmtree(targetdir)
try:
	os.mkdir(targetdir)
	print(targetdir+"创建完成")
except:
	print("创建"+targetdir+"发生异常")


try:
	os.mkdir(targetdir+"\js")
	print(targetdir+"\js"+"创建完成")
except:
	print(targetdir+"\js"+"已被创建")
shutil.copyfile('js\jquery-1.2.6.pack.js', targetdir+"\js\jquery-1.2.6.pack.js")
print(targetdir+"\js\jquery-1.2.6.pack.js"+"复制完成")
shutil.copyfile('js\jquery-doc-split.js', targetdir+"\js\jquery-doc-split.js")
print(targetdir+"\js\jquery-doc-split.js"+"复制完成")


try:
	os.mkdir(targetdir+"\style")
	print(targetdir+"\style"+"创建完成")
except:
	print(targetdir+"\style"+"已被创建")
shutil.copyfile('style\style.css', targetdir+"\style\style.css")
print(targetdir+"\style\style.css"+"复制完成")
shutil.copyfile('style\style.xsl', targetdir+"\style\style.xsl")
print(targetdir+"\style\style.xsl"+"复制完成")
shutil.copyfile('changelog.txt', targetdir+"\changelog.txt")
print(targetdir+"\changelog.txt"+"复制完成")

paths = os.listdir( 'xml2chm' )
for path in paths:
	if path[-4:].lower() != ".svn".lower():
		filePath = os.path.join( targetdir, path )
		shutil.copyfile(os.path.join( 'xml2chm', path ), filePath)
		print(filePath+"复制完成")


print("开始生成xml")
i=0
def write2file(node,method,fname=""):
	global i
	i+=1
	filename=targetdir+"\\"+(method+fname)+".xml"
	if os.path.isfile(filename):
		filename=targetdir+"\\"+(method+fname)+"-1.xml"
	xm=codecs.open(filename,"w","utf-8")
	xm.writelines("<?xml version='1.0' encoding='utf-8'?>")
	xm.writelines("<?xml-stylesheet type='text/xsl' href='style/style.xsl'?>")
	xm.writelines(node.toxml())
	xm.close()

for node in xmldoc.getElementsByTagName("function"):
	method=node.getAttribute("name");
	params=node.getElementsByTagName("params")
	fname=""
	for param in params:
		fname+="_"+param.getAttribute("name")
	write2file(node,method,fname)

for node in xmldoc.getElementsByTagName("selector"):
	method=node.getAttribute("name");
	write2file(node,method)

for node in xmldoc.getElementsByTagName("property"):
	method=node.getAttribute("name");
	write2file(node,method)

print("生成xml结束，共生成"+str(i)+"个xml文件。")

print("正在生成chm文件")

if os.path.exists(hhc):
	os.spawnl(os.P_WAIT,hhc,"hhc",os.path.join(targetdir,"jqapichm.hhp"))

if os.path.exists("dist"):
	print("正在删除现有的dist")
	shutil.rmtree("dist")
try:
	os.mkdir("dist")
	os.mkdir("dist\\chm")
	os.mkdir("dist\\xml")
	os.mkdir("dist\\xml\\style")
	os.mkdir("dist\\xml\\js")
	print("dist创建完成")
except:
	print("创建dist发生异常")

shutil.copyfile(r'build\jqapichm.chm', r'dist\chm\jqapichm.chm')
shutil.copyfile(r'xml2chm\fixxml.reg', r'dist\chm\fixxml.reg')
shutil.copyfile(r'xml2chm\readme.txt', r'dist\chm\readme.txt')
print("chm发布完成")

shutil.copyfile(r'jqueryapi.xml', r'dist\xml\jqueryapi.xml')
shutil.copyfile(r'js\jquery-1.2.6.pack.js', r'dist\xml\js\jquery-1.2.6.pack.js')
shutil.copyfile(r'js\jquery-doc.js', r'dist\xml\js\jquery-doc.js')
shutil.copyfile(r'style\style.css', r'dist\xml\style\style.css')
shutil.copyfile(r'style\stylecn.xsl', r'dist\xml\style\stylecn.xsl')
print("xml发布完成")

print("你可以在dist文件夹下找到对应的发布版本。")


os.system("pause")