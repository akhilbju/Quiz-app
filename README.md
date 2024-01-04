It is a backend code for Quiz generation from the question that already stored in the database  

localhost:8080/question/create/question -add question into database

localhost:8080/question/getqstn  -get all questions from database

localhost:8080/question/delete/{id} - delete question from database

localhost:8080/quiz/create?name=name&qno=no&difficulty=easy  -we can generate quiz by using this qno=no of questions ,difficulty can be easy,medium,hard

localhost:8080/quiz/result/{id}  - we can get the score

