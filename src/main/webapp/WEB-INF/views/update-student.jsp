<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h2>Update Student</h2>

    <p class="error">${error}</p>

    <form action="/students/update/${student.id}" method="post">
        <label>Student Name</label>
        <input type="text" name="studentName" value="${student.studentName}" required>

        <label>Email</label>
        <input type="email" name="email" value="${student.email}" required>

        <label>Age</label>
        <input type="number" name="age" value="${student.age}" required>

        <label>Select Course</label>
        <select name="courseId" required>
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}"
                    <c:if test="${student.course.id == course.id}">selected</c:if>>
                    ${course.courseName}
                </option>
            </c:forEach>
        </select>

        <button type="submit">Update Student</button>
    </form>

    <a href="/students">Back to Students</a>
</div>

</body>
</html>