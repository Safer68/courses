<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.admin}">

    <a href="newAdmin">ADD NEW MENTOR</a>
    <div class="row mx-2">
    <table class="table">
        <thead>
        <tr>
            <th class="col">№</th>
            <th class="col">ID</th>
            <th class="col">Mentor name</th>
            <th class="col">Edit</th>
            <th class="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="adminMentor" items="${adminMentor}" varStatus="status">
            <tr>
                <td class="col">${status.index+1}</td>
                <td class="col">${adminMentor.id}</td>
                <td class="col">${adminMentor.nameMentor}</td>
                <td class="col"><a href="updateAdminMentor?adminMentorId=${adminMentor.id}">EDIT</a></td>
                <td class="col"><a href="adminMentorDelete?adminMentorId=${adminMentor.id}">DELETE</a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type='submit' id="return" name="return">Return to admin list</button>
</c:if>
</div>

