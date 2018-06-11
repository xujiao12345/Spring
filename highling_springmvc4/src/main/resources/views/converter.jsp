<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html;charset=UTF-8" http-equiv="Content_Type">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
    <div id="resp">
        <input type="button" onclick="req();" value="请求"/>
    </div>
    <script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
    <script>
        function req() {
            $.ajax({
                url:"convert",
                data:"1-xujiao",
                type:"POST",
                contentType:"application/x-wisely",
                success:function (data) {
                    $("#resp").html(data);
                }
            })
        }
    </script>
</body>
</html>