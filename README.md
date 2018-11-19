# Intranet-Based-Student-Profile-Management-System

Introduction

We would like to begin by highlighting the fact that the main goal of this project was to fix all learned knowledge during Object – oriented programming course and to apply them while creating a “University Study System”. 
The following project was done in a group, so another goal was to develop our teamwork skills, so in the future we can apply them in real work. 
The main objective could be incarnated by utilizing all OOP concepts.
In order to create a project, we followed a simple plan that consisted of UML diagram creation and Code implementation.  
Overall, this project helped us to review covered topics and gave us a general idea about teamwork.

General requirements:
-	OOP style
-	Properly Serialization
-	Intuitive usage
-	Consistency with UML
-	Comparable, Cloneable, Serializable, equals(), hashcode(), toString()…
-	Proper and logically consistent usage of Collections
-	Usage of java api (standard classes). Do not reinvent the bicycle.

Approximate Checklist:
-	Admin
o	Manage Users (Add, remove, update)
-	Teacher
o	View Courses
o	Manage Course files
o	View Students, info about students
o	Put marks
o	Send order to Executors (actually, any employee can send the order)
-	Student
o	View Courses, Register for Courses
o	View Course files
o	View info about teacher of a specific course
o	View Marks
o	View Transcript
o	Rate teachers
o	Get Trasncript
-	Executor
o	Accept/reject order
o	View orders (after that accept some order, for example)
o	View accepted orders
o	getSalary() must be overridden to account for hardworking executors (they must get higher salary).
-	Manager
o	Approve students registration
o	Assign courses to teachers
o	Manager types – OR, Deparments, etc. (use enumeration).
o	Create statistical reports on academic performance
o	Manage news
Important note:
Account for details! For example:
o	Students can’t have more than 21 credits
o	Students can’t fail more than 3 times
o	FIT Students can’t have FOGI courses (only as electives)
o	Mark consists of 1st, 2nd attestation, and final.
o	Many more, really … 

