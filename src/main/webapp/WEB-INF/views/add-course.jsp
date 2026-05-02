<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <h2>Add Course</h2>

    <p class="error">${error}</p>

    <form action="/courses/save" method="post">
        <label>Course Name</label>
        <input type="text" name="courseName" required>

        <label>Instructor</label>
        <input type="text" name="instructor" required>

        <label>Duration in Months</label>
        <input type="number" name="durationInMonths" required>

        <button type="submit">Save Course</button>
    </form>

    <a href="/">Back to Home</a>
</div>

</body>
</html>