$.ajax({
    url: 'getQuestionsForQuiz',
    traditional: true,
    data: {
        numberOfQuestions: $("#numberOfQuestions").val(),
        categories: $("#categories").val()
    },
    success: function (result) {
        var questions = JSON.parse(result);
        startQuiz(questions);
    }
})

function startQuiz(questions){
    function buildQuiz(){
        // variable to store the HTML output
        const output = [];

        // for each question...
        myQuestions.forEach(
            (currentQuestion, questionNumber) => {

                // variable to store the list of possible answers
                const answers = [];

                    // ...add an HTML radio button
                    answers.push(`<label>
              <input type="radio" name="question${questionNumber}" value="${"A"}">
              ${"A"} :
              ${currentQuestion.answerA}
            </label>`);
                answers.push(`<label>
              <input type="radio" name="question${questionNumber}" value="${"B"}">
              ${"B"} :
              ${currentQuestion.answerB}
            </label>`);
                answers.push(`<label>
              <input type="radio" name="question${questionNumber}" value="${"C"}">
              ${"C"} :
              ${currentQuestion.answerC}
            </label>`);
                answers.push(`<label>
              <input type="radio" name="question${questionNumber}" value="${"D"}">
              ${"D"} :
              ${currentQuestion.answerD}
            </label>`);

                // add this question and its answers to the output
                output.push(
                    `<div class="slide">
    <div class="question"> ${currentQuestion.content} </div>
    <div class="answers"> ${answers.join("")} </div>
  </div>`
                );
            }
        );

        // finally combine our output list into one string of HTML and put it on the page
        quizContainer.innerHTML = output.join('');
    }

    function showResults(){

        // gather answer containers from our quiz
        const answerContainers = quizContainer.querySelectorAll('.answers');

        // keep track of user's answers
        let numCorrect = 0;

        // for each question...
        myQuestions.forEach( (currentQuestion, questionNumber) => {

            // find selected answer
            const answerContainer = answerContainers[questionNumber];
            const selector = `input[name=question${questionNumber}]:checked`;
            const userAnswer = (answerContainer.querySelector(selector) || {}).value;

            // if answer is correct
            if(userAnswer === currentQuestion.correctAnswer){
                numCorrect++;
            }
        });

        var result = {
            questions : myQuestions.length,
            correctAnswers :  numCorrect,
            categories: $("#categories").val()
        }

        $.ajax({
            type: "POST",
            url: 'summarizeQuiz',
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify(result),
            crossDomain: false,
            success:function(result) {
                window.location = '/summarizeQuiz';
            },
            error: function(result){
                window.location = '/summarizeQuiz';
            }
        })

        // show number of correct answers out of total
        //resultsContainer.innerHTML = `${numCorrect} out of ${myQuestions.length}`;
    }

    const quizContainer = document.getElementById('quiz');
    const submitButton = document.getElementById('submit');
    const myQuestions = questions;

    // Kick things off
    buildQuiz();

    const nextButton = document.getElementById("next");
    const slides = document.querySelectorAll(".slide");
    let currentSlide = 0;

    function showSlide(n) {
        slides[currentSlide].classList.remove('active-slide');
        slides[n].classList.add('active-slide');
        currentSlide = n;
        if(currentSlide === slides.length-1){
            nextButton.style.display = 'none';
            submitButton.style.display = 'inline-block';
        }
        else{
            nextButton.style.display = 'inline-block';
            submitButton.style.display = 'none';
        }
    }

    function showNextSlide() {
        showSlide(currentSlide + 1);
    }


    showSlide(currentSlide);

    // Event listeners
    submitButton.addEventListener('click', showResults);

    nextButton.addEventListener("click", showNextSlide);

};

