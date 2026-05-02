<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h2>Add Student</h2>

    <p class="error">${error}</p>

    <form action="/students/save" method="post">
        <label>Student Name</label>
        <input type="text" name="studentName" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Age</label>
        <input type="number" name="age" required>

        <label>Select Course</label>
        <select name="courseId" required>
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">
                    ${course.courseName}
                </option>
            </c:forEach>
        </select>

        <button type="submit">Save Student</button>
    </form>

    <a href="/">Back to Home</a>
</div>

</body>
</html>