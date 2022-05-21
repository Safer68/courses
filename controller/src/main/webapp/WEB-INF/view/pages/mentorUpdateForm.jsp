<%--
  Created by IntelliJ IDEA.
  User: yusikov_av
  Date: 17.05.2022
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="${pageContext.request.contextPath}/home?pageName=mentor" name="inserting"
      method="post">
    <div class="gy-5">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6 text-secondary form-floating mb-3">
                <input type="text"
                       class="form-control"
                       id="floatingInput"
                       placeholder="Enter name"
                       name="name"
                       value="${mentorNameForUpdate}"
                >
                <label for="floatingInput">&nbspMentor name</label>
            </div>
        </div>

        <c:choose>
            <c:when test="${not empty sessionScope.allCourseForMentor}">
                <c:forEach var="course" items="${allCourseForMentor}" varStatus="status">
                    <div class="row">
                        <div class="col-4"></div>
                        <div class="col-5 form-check form-switch">
                            <input class="col-1 form-check-input"
                                   type="checkbox"
                                   role="switch"
                                   name="courseId"
                                   value="${course.id}"
                                ${course.checked}
                                   id="flexSwitchCheckCourse">
                            <label class="col-4 form-check-label"
                                   for="flexSwitchCheckCourse">${course.courseProgram}</label>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <span class="border-primary text-danger">No courses without mentor</span>
            </c:otherwise>
        </c:choose>
        <c:forEach var="admin" items="${allAdminForMentor}" varStatus="status">
            <div class="row">
                <div class="col-4"></div>

                <div class="col-5 form-check">
                    <input class="form-check-input"
                           type="radio"
                           name="adminId"
                           value="${admin.id}"
                        ${admin.checked}
                           id="flexRadioDefault1">
                    <label class="col-4 form-check-label"
                           for="flexRadioDefault1">
                            ${admin.adminName}
                    </label>
                </div>
            </div>
        </c:forEach>
        <input type="hidden" name="mentorId" value="${mentorId}"/>
        <button class="btn btn-outline-primary"><i class="bi bi-save"></i>&nbsp;Save</button>
    </div>
</form>

