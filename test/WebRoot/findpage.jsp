<%@ page language="java" import="java.util.*,com.ascent.util.*" pageEncoding="gb2312"%>
	<script language="JavaScript">
		function Jumping(){
			document.pageForm.submit();
	    }    
	    function gotoPage(pagenum){
	    	var jumppageobj= document.getElementById("dpage");
	    	document.getElementById("dpage").value = pagenum;
	    	document.pageForm.submit();
	    }
  	</script>
  	<%
  		FindPage nfp = (FindPage) request.getAttribute("page");
  	%>
  	<table>
  		<tr>
			<td>第<%=nfp.getCurrentPage()%>页</td>
		    <td>
		    	<%
		    		if(nfp.getCurrentPage()==1){
		    			out.print("首页　上一页");
		    		} else {
		    	%>
		        		<a href="javascript:gotoPage(1)">首页</a>
		        		<a href="javascript:gotoPage(<%=nfp.getCurrentPage()-1%>)">上一页</a>
		        <%
		        	}
		        %>
		     </td>
		     <td>
		        <%
		       		if(nfp.getCurrentPage()==nfp.getTotalPage() || nfp.getTotalPage()==0){
		       			out.print("下一页　尾页");
		       		} else {
		       	%>
		       			<a href="javascript:gotoPage(<%=nfp.getCurrentPage()+1%>)">下一页</a>
		       			<a href="javascript:gotoPage(<%=nfp.getTotalPage()%>)">尾页</a>
		       	<%	
		       		}
		       	%>
		    </td>
		    <td>
		    	<%
		    		if(nfp.getTotalPage()==0){
		    	%>
		    			共1页
		    	<%
		    		} else {
		    	%>
		    			共<%=nfp.getTotalPage()%>页
		    	<%
		    		}
		    	%>
		    </td>
		    <td>转到第</td>
		    <td>
		    	<select name="dpage" onchange="Jumping()">
					<%
						for(int i=1;i<=nfp.getTotalPage();i++){
							if(i==nfp.getCurrentPage()){
					%>
								<option selected value="<%=i%>"><%=i%></option>
					<%
					    	} else {
					%>
								<option value="<%=i%>"><%=i%></option>
					<%
							}
						}
					%>
				</select>
			</td>
			<td>页</td>
		</tr>
	</table>
