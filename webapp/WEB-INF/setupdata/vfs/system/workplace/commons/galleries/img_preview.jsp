<%@ page import="org.opencms.jsp.*, org.opencms.workplace.commons.*" buffer="none" session="false" %>
<%	
	// initialize action element for link substitution
	CmsJspActionElement cms = new CmsJspActionElement(pageContext, request, response);
	// initialize the workplace class
	CmsGalleryImages wp = new CmsGalleryImages(pageContext, request, response);	
%>
<%= wp.htmlStart(null) %>
	<style type="text/css">
	<!--
		td.list { white-space: nowrap; padding-left: 2px; }
		
		td.headline { padding: 1px; white-space: nowrap; background:Menu; border-right: 1px solid ThreedDarkShadow; border-top: 1px solid ThreeDHighlight; border-bottom: 1px solid ThreedDarkShadow; border-left: 1px solid ThreeDHighlight; }
	//-->
	</style>	
	<script language="javascript">
	<!--
		function pasteResource(uri, title, desc) {
		<% 	
			if (wp.MODE_WIDGET.equals(wp.getParamDialogMode())) {
		%>
			top.window.opener.document.getElementById("<%= wp.getParamFieldId() %>").value  = uri;
			try {
				// toggle preview icon if possible
				top.window.opener.checkPreview("<%= wp.getParamFieldId() %>");
			} catch (e) {}
		<%	
			} else { 
		%>
				var result = "<img src=\"";
				result += uri;
				result += "\" title=\"";
				result += title;
				result += "\" alt=\"";
				result += desc;
				result += "\" border=\"0\">";
				top.window.opener.insertHtml(result);
		<%
			}
		%>
			top.window.close();
		}
		
		function deleteResource(uri) {
			top.gallery_fs.gallery_list.location.href="/opencms/opencms/system/workplace/commons/delete.jsp?resource="+uri;			
		}
		
	//-->
	</script>	
</head>
<body class="dialog" height="100%" unselectable="on">
<form class="nomargin" name="form">
<%= wp.buildGalleryItemPreview() %>
</form>
</body>
<%= wp.htmlEnd() %>