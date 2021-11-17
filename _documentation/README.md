# grit-java-ass1
first assignment in the basic java course in GritJava21

Project document
https://docs.google.com/document/d/1AfxGSOS5WRmgdE7pMZh3WyzK8KYSztxfgXj_4LUPlOg/edit#

DrawIo
Install the drawIO editor if you want to use or change the diagram

How to run the show
- Folder path for the gradebook files are relative in Filehandler class String basePath = "/_gradebooks/";  
- 
- Run the app
- Now there is a continuous loop in Main running the UI and the logic
- Select 0 to see all the files in the path above
- Select 1 to create a new gradebook file
- Select 2 to select a gradebook and list students in it
- Selection 3-6 works with the file selected in 2
- Exit with 100


**Filestructure for the gradebook**  
studentName_1  
studentSSN_1  
studentCourse_1  
studentCourse_1_Grade  
_COURSE SEPARATOR --> "newcourse"_  
studentCourse_2  
studentCourse_2_Grade  
_COURSE SEPARATOR --> "newcourse"_  
studentCourse_n  
studentCourse_n_Grade  
**STUDENT SEPARATOR --> "/"**  
studentName_2  
studentSSN_2  
studentCourse_1  
studentCourse_1_Grade  
_COURSE SEPARATOR --> "newcourse"_  
studentCourse_2  
studentCourse_2_Grade  
_COURSE SEPARATOR --> "newcourse"_  
studentCourse_n  
studentCourse_n_Grade  
**STUDENT SEPARATOR --> "/"**
studentName_n  
studentSSN_n  
studentCourse_1  
studentCourse_1_Grade  
_COURSE SEPARATOR --> "newcourse"_  
studentCourse_2  
studentCourse_2_Grade  
_COURSE SEPARATOR --> "newcourse"_  
studentCourse_n  
studentCourse_n_Grade