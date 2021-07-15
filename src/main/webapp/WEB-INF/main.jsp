<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    MAIN JSP<br>
    Origin URL : <input type="text" id="originUrl" name="originUrl" value="https://www.naver.com"> <input type="button" id="convertUrl" value="Convert">
    <br>
    Change URL : <p id="changeUrl"></p>
</body>
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<script>
    $(document).on("click", "#convertUrl", function (params) {
        let url = $("#originUrl").val();
        let isCheckUrl = validateUrl(url);
     
        if(isCheckUrl){
            setConvertUrl(url);
        }else{
            alert("Please Check Url");
        }
    });

    function validateUrl(url) {
        let isCheckUrl = false;
        
        if(url.length > 0){
            const urlRegex = /(https|http)?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)/;
            const urlValidate = new RegExp(urlRegex);
            let result = urlValidate.test(url);
            return result;
        }
        return isCheckUrl;
    }

    function setConvertUrl(originUrl) {
        var obj = new Object();
        obj.originUrl = originUrl;
        var jsonData = JSON.stringify(obj);

        $.ajax({
            url: "/convertUrl",
            method:"post",
            contentType : "application/json",
            data : jsonData,
            dataType   : 'json'
        })
        .done(function (data, textStatus, xhr) {
            console.log(data);
            if(data.code === 200){
                $("#changeUrl").text(data.shorteningUrl);
                alert("Success");
            }else{
                alert(data.errorList[0].message);
            }
        })
        .fail(function(data, textStatus, errorThrown){
            console.log(data);
        });
    }
</script>
</html>