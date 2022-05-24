<%--
  Created by IntelliJ IDEA.
  User: Flashsan
  Date: 17.05.2022
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Delete admin course</h1>

<form action="adminCourseDelete" method="POST">
    <fieldset>
        ID
        <input name="deleteAdminCourse" type="ID" value=<%=request.getParameter("adminCourseId")%> readonly="readonly"><br>
        <input type='submit' value='Delete'>
        <button type='submit' id="cancel" name="cancel">Cancel</button>
    </fieldset>
</form>
</div>
</body>
</html>
