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
			<td>��<%=nfp.getCurrentPage()%>ҳ</td>
		    <td>
		    	<%
		    		if(nfp.getCurrentPage()==1){
		    			out.print("��ҳ����һҳ");
		    		} else {
		    	%>
		        		<a href="javascript:gotoPage(1)">��ҳ</a>
		        		<a href="javascript:gotoPage(<%=nfp.getCurrentPage()-1%>)">��һҳ</a>
		        <%
		        	}
		        %>
		     </td>
		     <td>
		        <%
		       		if(nfp.getCurrentPage()==nfp.getTotalPage() || nfp.getTotalPage()==0){
		       			out.print("��һҳ��βҳ");
		       		} else {
		       	%>
		       			<a href="javascript:gotoPage(<%=nfp.getCurrentPage()+1%>)">��һҳ</a>
		       			<a href="javascript:gotoPage(<%=nfp.getTotalPage()%>)">βҳ</a>
		       	<%	
		       		}
		       	%>
		    </td>
		    <td>
		    	<%
		    		if(nfp.getTotalPage()==0){
		    	%>
		    			��1ҳ
		    	<%
		    		} else {
		    	%>
		    			��<%=nfp.getTotalPage()%>ҳ
		    	<%
		    		}
		    	%>
		    </td>
		    <td>ת����</td>
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
			<td>ҳ</td>
		</tr>
	</table>
