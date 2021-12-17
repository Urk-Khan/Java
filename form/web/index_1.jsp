<%-- 
    Document   : index
    Created on : Dec 13, 2021, 1:04:35 PM
    Author     : urkkh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Form</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class ="container">
            <form method="post" action="validaionServlet">
                <div class="form-group">
                    
                    User Name <input type="text" name="textUser" placeholder="User Name">
                </div>
                <div class="form-group">
                    Name <input type="password" name="textPassword" placeholder="Password">
                </div>
                <div class="form-group">
                    <input type="submit" value="Login">
                </div>
                
            </form>
        </div>
    </body>
</html>
