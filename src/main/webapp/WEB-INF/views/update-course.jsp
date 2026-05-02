<!DOCTYPE html>
<html>
<head>
    <title>Update Course</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h2>Update Course</h2>

    <p class="error">${error}</p>

    <form action="/courses/update/${course.id}" method="post">
        <label>Course Name</label>
        <input type="text" name="courseName" value="${course.courseName}" required>

        <label>Instructor</label>
        <input type="text" name="instructor" value="${course.instructor}" required>

        <label>Duration in Months</label>
        <input type="number" name="durationInMonths" value="${course.durationInMonths}" required>

        <button type="submit">Update Course</button>
    </form>

    <a href="/courses">Back to Courses</a>
</div>

</body>
</html>

