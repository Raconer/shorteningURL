<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body data-url="${originUrl}">
    <c:if test="${!(originUrl.length() > 0)}">
        주소를 다시 확인해 주세요
    </c:if>
</body>
<script>
    let url = document.getElementsByTagName("body")[0].dataset.url;
    if(url.length > 0){
        location.href = url;
    }
</script>
</html>