<%@ page language="java" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String who = (String)request.getAttribute("who");
if (who==null || "".equals(who))
	who = (String)request.getParameter("who");
%>
		<table width="99%" border="0" cellspacing="0" cellpadding="0" id="secTable">
			<tr>
				<td width="2%" height="24">&nbsp;</td>
			<td width="16%" class="tabin_atabno">
                <span onclick="javascript:admissionDeal('newReceiveList');" onmouseover="this.style.cursor='hand'">新收到的收文</span> 
			</td>
			<td width="16%" class="tabin_atabno">
                <span onclick="javascript:admissionDeal('disposingList');" onmouseover="this.style.cursor='hand'">正在办理的收文</span>
			</td>
			<td width="16%" class="tabin_atabno">
				 <span onclick="javascript:admissionDeal('canMonitorList');" onmouseover="this.style.cursor='hand'">可监控的收文</span>
			</td>
			<td width="16%" class="tabin_atabno">
                <span onclick="javascript:admissionDeal('disposedList');" onmouseover="this.style.cursor='hand'">已办理的收文</span>
			</td>
			<td width="16%" class="tabin_atabno">
                <span onclick="javascript:admissionDeal('bookingList');" onmouseover="this.style.cursor='hand'">新起草的收文</span>
            </td>
            <%if("true".equals(who)){%>
			<td colspan="3" align="center">
                <input name="Submit2" type="button" class="button0" value="收文登记" onclick="admissionRec();"	 onmouseover="this.style.cursor='hand'"/>
			</td>
			<%}%>
            <%--<td width="2%">
                <span onclick="javascript:back();" onmouseover="this.style.cursor='hand'">返回</span>
            </td>
            <td>&nbsp;</td>
         --%></tr>
	</table>

<script language="javascript">
function admissionDeal(which)
{
	window.location.href="<%=path%>/docRecListAction.do?method="+which;
}
function admissionRec()
{
	window.location.href="<%=path%>/docrecBook.do?method=input";
}
function back()
{
	window.location.href="<%=path%>/docRecListAction.do?method=newAndDisposingList";
}
</script>