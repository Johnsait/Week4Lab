<%-- 
    Document   : viewnote
    Created on : 5-Feb-2023, 5:41:31 PM
    Author     : JohnC. <john.crudo@edu.sait.ca>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><strong>Title:</strong> ${note.title}</p>
        <p><strong>Contents: </strong> <br>${note.contents}</p>
        <a href="note?edit">Edit</a> 
    </body>
</html>
