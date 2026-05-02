<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h2>Student List with Course Details</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Student Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Course</th>
            <th>Instructor</th>
            <th>Action</th>
        </tr>

        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.studentName}</td>
                <td>${student.email}</td>
                <td>${student.age}</td>
                <td>${student.course.courseName}</td>
                <td>${student.course.instructor}</td>
                <td>
                    <a href="/students/edit/${student.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="/">Back to Home</a>
</div>

</body>
</html>