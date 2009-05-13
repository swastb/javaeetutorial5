<%@ page language="java"
	import="java.util.*,java.sql.SQLException,java.io.IOException,java.io.*"
	import="org.hibernate.lob.SerializableClob" 
	import="java.sql.Clob"
	import="java.io.BufferedReader"
	import="java.io.Reader" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%!public String ClobToString(Clob clob) {
		String reString = "";
		try {
			Reader reader = clob.getCharacterStream();
			char[] buffer = new char[(int) clob.length()];
			reader.read(buffer);
			reader.close();
			return new String(buffer).replaceAll("\\\\\"", "\"");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reString;
	}%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List resultList = (List) request.getAttribute("resultList");
%>

<%
			String[] iUrl= new String[4];
			iUrl[0] = path+"/imagine/szy_1.jpg";
			iUrl[1] = path+"/imagine/szy_2.jpg";
			iUrl[2] = path+"/imagine/szy_3.jpg";
			iUrl[3] = path+"/imagine/szy_4.jpg";
			
		 	if (resultList != null && !resultList.isEmpty()) {
		 		int size = resultList.size();
		 		if (size>4)
		 			size = 4;
	
				for (int i = 0; i < size; i++) {
					TbInfoPubContent item1 = (TbInfoPubContent) resultList.get(i);
					java.sql.Clob clob = item1.getContent();
					String content = "";
					if(clob!=null){
						content = ClobToString(clob);
					}
					String imageUrl = path+"/imagine/sy-tp3.gif";
					String contentStr = content.replace("<BR>","").replace("<P>","").replace("</P>","").replace("<DIV>","").replace("</DIV>","");
					System.out.println("contentStr---"+contentStr);
					if (contentStr.indexOf("<IMG")!=1 && contentStr.indexOf("/sso/UploadFile")!=-1) {
						List list = new ArrayList();
						int imgHZM = 0;
						list.add(contentStr.indexOf(".JPG"));
						list.add(contentStr.indexOf(".GIF"));
						list.add(contentStr.indexOf(".BMP"));
						list.add(contentStr.indexOf(".jpg"));
						list.add(contentStr.indexOf(".gif"));
						list.add(contentStr.indexOf(".bmp"));
						System.out.println(".jpg--"+contentStr.indexOf(".jpg"));
						System.out.println(".gif--"+contentStr.indexOf(".gif"));
						System.out.println(".bmp--"+contentStr.indexOf(".bmp"));
						for (int k=0;k<list.size();k++) {
							if (((Integer)list.get(k)).intValue() > 1) {
								imgHZM = ((Integer)list.get(k)).intValue();
								break;
							}
						}
						if (imgHZM > 0){
							imageUrl = contentStr.substring(contentStr.indexOf("/sso/UploadFile"),imgHZM+4);
							iUrl[i]=imageUrl;
							}
						int psize = imgHZM+4;
						while (content.charAt(psize)!='>' && psize<content.length()) {
							psize++;
						}
						//System.out.println("---psize--=="+psize);
						contentStr = contentStr.substring(psize-2);
					}
					//System.out.println("contentStr---"+contentStr);
					
					}}
		
		%>
            



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>水资源动态</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
	</head>

	<body topmargin="0" bgcolor="eefaff">
		<table width="305" height="130" align="center" border="0">
			<tr>
				<td height="130" align="center">
				
		
		<script language="javascript" type="text/javascript">
var imgWidth=250;              //图片宽
var imgHeight=130;             //图片高
var textFromHeight=0;         //焦点字框高度 (单位为px)
var textStyle="f12";           //焦点字class style (不是连接class)
var textLinkStyle="p1"; //焦点字连接class style
var buttonLineOn="#f60";           //button下划线on的颜色
var buttonLineOff="#000";          //button下划线off的颜色
var TimeOut=4000;              //每张图切换时间 (单位毫秒);
var imgUrl=new Array(); 
var imgLink=new Array();
var imgtext=new Array();
var imgAlt=new Array();
var adNum=0;


imgUrl[1]='<%=iUrl[0]%>';
imgtext[1]='<a href="#" target="_blank" class="'+textLinkStyle+'"></a>';
imgLink[1]='<%=path%>/infopubContentaction.do?method=szydt_more&name=水资源动态&code=szydt';
imgAlt[1]=' ';

imgUrl[2]='<%=iUrl[1]%>';
imgtext[2]='<a href="#" target="_blank" class="'+textLinkStyle+'"></a>';
imgLink[2]='<%=path%>/infopubContentaction.do?method=szydt_more&name=水资源动态&code=szydt';
imgAlt[2]=' ';


imgUrl[3]='<%=iUrl[2]%>';
imgtext[3]='<a href="#" target="_blank" class="'+textLinkStyle+'"></a>';
imgLink[3]='<%=path%>/infopubContentaction.do?method=szydt_more&name=水资源动态&code=szydt';
imgAlt[3]=' ';

imgUrl[4]='<%=iUrl[3]%>';
imgtext[4]='<a href="#" target="_blank" class="'+textLinkStyle+'"></a>';
imgLink[4]='<%=path%>/infopubContentaction.do?method=szydt_more&name=水资源动态&code=szydt';
imgAlt[4]=' ';



document.write('<div id="focuseFrom" style="width:'+(imgWidth+2)+';margin: 0px; padding:0px;height:'+(imgHeight+textFromHeight)+'px; overflow:hidden;">');
function changeimg(n)
{
     adNum=n;
     window.clearInterval(theTimer);
     adNum=adNum-1;
     nextAd();
}
function goUrl(){
     window.open(imgLink[adNum],'_blank');
}

//NetScape开始
if (navigator.appName == "Netscape")
{
     var count=0;
     for (i=1;i<imgUrl.length;i++) {
           if( (imgUrl[ i ]!="") && (imgLink[ i ]!="")&&(imgtext[ i ]!="")&&(imgAlt[ i ]!="") ) {
                 count++;
           } else {
                 break;
           }
     }
     function nextAd(){
           if(adNum<(imgUrl.length-1))adNum++;
           else adNum=1;
                 theTimer=setTimeout("nextAd()", TimeOut);
                 document.images.imgInit.src=imgUrl[adNum];
                 document.images.imgInit.alt=imgAlt[adNum];      
                 document.getElementById('focustext').innerHTML=imgtext[adNum];
                 document.getElementById('imgLink').href=imgLink[adNum];
                 document.getElementById('link'+adNum).style.background=buttonLineOn;
                 for (var i=1;i<=count;i++)
                 {
                        if (i!=adNum){document.getElementById('link'+i).style.background=buttonLineOff;}
                 }      

     }
     document.write('<a id="imgLink" href="'+imgLink[1]+'" target=_blank class="p1"><img src="'+imgUrl[1]+'" name="imgInit" width='+imgWidth+' height='+imgHeight+' border=1 alt="'+imgAlt[1]+'" class="imgClass"></a>');
     document.write('<div id="txtFrom" style="height:'+textFromHeight+'px;line-height:'+textFromHeight+'px;width:'+imgWidth+'px;overflow:hidden;"><span id="focustext" class="'+textStyle+'">'+imgtext[1]+'</span></div>');
     document.write('<div id="imgTitle" style="width:'+imgWidth+';top:-'+(textFromHeight+13)+'px;height:13px">');
     document.write('<div id="imgTitle_down">');
     //数字按钮代码开始
     for(var i=1;i<imgUrl.length;i++){document.write('<a id="link'+i+'"  href="javascript:changeimg('+i+')" class="button" style="cursor:hand" title="'+imgAlt[ i ]+'" onfocus="this.blur()">'+i+'</a>');}
     //数字按钮代码结束
     document.write('</div>');
     document.write('</div>');
     document.write('</div>');
     nextAd();
}
//NetScape结束
//IE开始
else
{
     var count=0;
     for (i=1;i<imgUrl.length;i++) {
           if( (imgUrl[ i ]!="") && (imgLink[ i ]!="")&&(imgtext[ i ]!="")&&(imgAlt[ i ]!="") ) {
                 count++;
           } else {
                 break;
           }
     }
     function playTran(){
           if (document.all)
                 imgInit.filters.revealTrans.play();            
     }
     var key=0;
     function nextAd(){
           if(adNum<count)adNum++ ;
           else adNum=1;
           
           if( key==0 ){
                 key=1;
           } else if (document.all) {
                 imgInit.filters.revealTrans.Transition=6;
                 imgInit.filters.revealTrans.apply();
                 playTran();
           }
           document.images.imgInit.src=imgUrl[adNum];
           document.images.imgInit.alt=imgAlt[adNum];      
           document.getElementById('link'+adNum).style.background=buttonLineOn;
           for (var i=1;i<=count;i++)
           {
                  if (i!=adNum){document.getElementById('link'+i).style.background=buttonLineOff;}
           }      
    focustext.innerHTML=imgtext[adNum];
           theTimer=setTimeout("nextAd()", TimeOut);
     }
     document.write('<a target="_self" href="javascript:goUrl()"><img style="FILTER: revealTrans(duration=1,transition=5);" src="javascript:nextAd()" width="'+imgWidth+'" height="'+imgHeight+'" border="0" vspace="0" name="imgInit" class="imgClass"></a>');
     document.write('<div id="txtFrom" style="height:'+textFromHeight+'px;line-height:'+textFromHeight+'px;width:'+imgWidth+'px;overflow:hidden;"><span id="focustext" class="'+textStyle+'"></span></div>');
     document.write('<div id="imgTitle" style="width:'+imgWidth+';top:-'+(textFromHeight+16)+'px;height:18px">');
     document.write(' <div id="imgTitle_down"> <a class="trans"></a>');
     //数字按钮代码开始
     for(var i=1;i<imgUrl.length;i++){document.write('<a id="link'+i+'"  href="javascript:changeimg('+i+')" class="button" style="cursor:hand" title="'+imgAlt[ i ]+'" onfocus="this.blur()">'+i+'</a>');}
     //数字按钮代码结束
     document.write('</div>');
     document.write('</div>');
     document.write('</div>');
}
//IE结束
</script>
			
			
			
			
			</td>
		</tr>
		</table>
		<table width="305" height="1" align="center" border="0"
			cellpadding="0" cellspacing="0">

			<%
					if (resultList != null && !resultList.isEmpty()) {
					for (int i = 0; i < resultList.size()-3; i++) {
						TbInfoPubContent item = (TbInfoPubContent) resultList
						.get(i);
						String title = "";
						title = item.getTitle();
						if (title.trim().length() > 16) {
					title = title.substring(0, 17) + "...";
						}
			%>
			
			
			<tr>
				<td width="10" height="18" class="zw">
					<img src="<%=path%>/imagine/ddddd2.gif" width="4" height="4">
				</td>
				<td height="22" class="zw">
					<a
						href="<%=path%>/infopubContentaction.do?method=view&id=<%=item.getId()%>"
						target="_blank"><%=title%> </a>
				</td>
				<td width="72" height="18" align="right" class="zw-time">[<%=item.getPublishTime() == null ? "" : item.getPublishTime().toString().substring(5, 10)%>]
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" background="<%=path%>/imagine/ddddd3.gif">
				</td>
			</tr>
			<%
				}
				}
			%>
			<table width="305" height="5" valign="top" align="center" border="0"
				cellpadding="0" cellspacing="0">
				<tr>
					<td width="225"></td>
					<td height="20" vaign="top" align="center">
						&nbsp;&nbsp;&nbsp;
						<a
							href="<%=path%>/infopubContentaction.do?method=szydt_more&name=水资源动态&code=szydt"
							target="_blank"><img src="<%=path%>/imagine/more.gif"
								width="41" height="11" border="0">&nbsp;</a>
					</td>
				</tr>
			</table>
		</table>
	</body>
</html>
