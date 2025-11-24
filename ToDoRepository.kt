package com.example.timemanagementapp.database

class ToDoRepository(
    private val examDao: ExamDao,
    private val assignmentDao: AssignmentDao,
    private val otherTaskDao: OtherTaskDao
) {

    // ----------- EXAM -----------
    suspend fun addExam(exam: Exam) = examDao.insertExam(exam)
    suspend fun getExams() = examDao.getAllExams()
    suspend fun updateExam(exam: Exam) = examDao.updateExam(exam)
    suspend fun deleteExam(exam: Exam) = examDao.deleteExam(exam)

    // -------- ASSIGNMENT --------
    suspend fun addAssignment(a: Assignment) = assignmentDao.insertAssignment(a)
    suspend fun getAssignments() = assignmentDao.getAllAssignments()
    suspend fun updateAssignment(a: Assignment) = assignmentDao.updateAssignment(a)
    suspend fun deleteAssignment(a: Assignment) = assignmentDao.deleteAssignment(a)

    // -------- OTHER TASK --------
    suspend fun addOtherTask(task: OtherTask) = otherTaskDao.insertOtherTask(task)
    suspend fun getOtherTasks() = otherTaskDao.getAllOtherTasks()
    suspend fun updateOtherTask(task: OtherTask) = otherTaskDao.updateOtherTask(task)
    suspend fun deleteOtherTask(task: OtherTask) = otherTaskDao.deleteOtherTask(task)
}
