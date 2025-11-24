package com.example.timemanagementapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class,
        Exam::class,
        Assignment::class,
        OtherTask::class
    ],
    version = 2,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    // DAOs
    abstract fun userDao(): UserDao
    abstract fun examDao(): ExamDao
    abstract fun assignmentDao(): AssignmentDao
    abstract fun otherTaskDao(): OtherTaskDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                )
                    .fallbackToDestructiveMigration()  // ⭐ prevents crashes during version change
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
