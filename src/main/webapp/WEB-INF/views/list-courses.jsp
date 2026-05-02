<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h2>Course List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Course Name</th>
            <th>Instructor</th>
            <th>Duration</th>
            <th>Action</th>
        </tr>

        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.instructor}</td>
                <td>${course.durationInMonths} months</td>
                <td>
                    <a href="/courses/edit/${course.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="/">Back to Home</a>
</div>

</body>
</html>