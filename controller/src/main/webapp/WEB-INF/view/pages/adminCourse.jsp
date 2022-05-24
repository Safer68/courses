<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.admin}">
    <a href="newAdmin">ADD NEW COURSE</a>
    <div class="row mx-2">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">ID</th>
                <th class="col">Course name</th>
                <th class="col">Edit</th>
                <th class="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="adminCourse" items="${adminCourse}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${adminCourse.id}</td>
                    <td class="col">${adminCourse.nameCourse}</td>
                    <td class="col"><a href="updateAdminCourse?adminCourseId=${adminCourse.id}">EDIT</a></td>
                    <td class="col"><a href="adminCourseDelete?adminCourseId=${adminCourse.id}">DELETE</a>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="adminCourse" method="POST">
            <button type='submit' id="return" name="return">Return to admin list</button>
        </form>

    </div>
</c:if>
