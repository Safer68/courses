<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.admin}">

    <a href="newAdmin">Add admin</a>

    <table class="table">
        <thead>
        <tr>
            <th class="col">№</th>
            <th class="col">Id</th>
            <th class="col">Name admin</th>
            <th class="col">List courses</th>
            <th class="col">List mentors</th>
            <th class="col">Edit</th>
            <th class="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="admin" items="${admin}" varStatus="status">
            <tr>
                <td class="col">${status.index+1}</td>
                <td class="col">${admin.id}</td>
                <td class="col">${admin.adminName}</td>
                <td class="col"><a href="adminCourse?adminId=${admin.id}">SHOW LIST COURSES</a></td>
                <td class="col"><a href="adminMentor?mentorId=${admin.id}">SHOW LIST MENTORS</a></td>
                <td class="col"><a href="adminUpdate?mentorId=${admin.id}">EDIT</a></td>
                <td class="col"><a href="adminDelete?adminId=${admin.id}">DELETE</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>


<%--<form action="${pageContext.request.contextPath}/adminId=${admin.id}" name="delete"--%>
<%--      method="post">--%>
<%--    <button class="btn btn-outline-secondary"><i class="bi bi-trash"></i></button>--%>
<%--</form>--%>