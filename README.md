# Student-Management-CRUD-Application
Performing here a CRUD Application.

This controller class in a Spring Boot project facilitates CRUD (Create, Read, Update, Delete) operations for a student management system:

1. Post Mapping (Create Student):-
   - The `saveStudents` method is responsible for adding new student records to the database. 
   - It accepts a POST request with JSON data representing a new student (`@RequestBody Student student`).
   - Upon receiving the request, it delegates the task of saving the student record to the service layer (`service.save(student)`).

2. Get Mapping (Get All Students and Get Student By Id):-
   - The `getStudents` method retrieves a list of all student records from the database.
   - The `get` method retrieves a specific student record by its ID.
   - Both methods return the requested data as JSON responses to the client.

3. Put Mapping (Update/Edit the Student By Id):-
   - The `updateStudent` method updates an existing student record identified by its ID.
   - It accepts a PUT request with JSON data representing the updated student information (`@RequestBody Student stud`).
   - The student's ID is extracted from the path (`@PathVariable("id") int id`) to determine which record to update.
   - The updated student record is then returned as a JSON response.

4. Delete Mapping(Delete Student By Id):-
   - The `delete` method deletes a student record from the database based on its ID.
   - It accepts a DELETE request with the student's ID provided in the URL path.
   - If the student record with the specified ID exists, it is deleted from the database. Otherwise, a "Not Found" response is returned.

Overall, this controller class provides a RESTful API interface for managing student records, allowing clients to perform CRUD operations seamlessly. It ensures proper handling of requests and responses while maintaining data integrity and security.