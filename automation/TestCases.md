#Test Case - QA tool

Step 1. Go to http://localhost:8000/
- Validate the next sections and elements are displayed:
  - Title and description
  - "Created questions" section
    - Title
    - Question´s list
    - Sort questions button (should be displayed in blue)
    - Remove questions (should be displayed in red)
  - "Create a new question" section
    - Title
    - Question input
    - Answer input
    - Create question button (should be displayed in green)

Step 2. Create a new question
- Introduce a question
- Introduce an answer
- Click on "Create question" button
- Validate question was added to the list

Step 3. Repeat at least once step 2 to have more than one question on the list

Step 4. Go to the question list and sort questions
- Validate list is sorted ascending

Step 5. Select any question and click on it
- Validate its answer is displayed

Step 6. Click again on the same question
- Validate answer is not displayed anymore

Step 7. Go to the question list and remove questions
- Validate "No questions yet :-(" is displayed