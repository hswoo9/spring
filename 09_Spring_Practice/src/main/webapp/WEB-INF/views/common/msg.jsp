<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		// ?λ¦Όλ©?Έμ§?λ₯? ???
		alert("${ msg }");
	
		// ?€??μΌμΌ?  ?€?¬λ¦½νΈκ°? ??Όλ©? ?€?
		if(${ not empty script }) {
			${ script }
		}
		
		// ??΄μ§? ?΄?
		location.replace("${ pageContext.request.contextPath }${ location }");
	</script>
</body>
</html>
