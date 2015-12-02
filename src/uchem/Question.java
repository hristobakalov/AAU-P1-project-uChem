package uchem;

public class Question {
	private static int questionCount = 0;
	
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private int correctAnswer;
	
	public Question(String question, String answer1, String answer2, String answer3, int correctAnswer){
		if(!question.isEmpty()){
			this.setQuestion(question);
		}
		else{
			throw new NullPointerException("Question can't be empty!");
		}
		this.setAnswer1(answer1);
		this.setAnswer2(answer2);
		this.setAnswer3(answer3);
		this.setCorrectAnswer(correctAnswer);
		
		questionCount++;
	}
	//incorrect remove maybe or refactor
	public static int getQuestionsCount(){
		return questionCount;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
    @Override
    public String toString() {
    	
    	String result ="";
    	result += question +" @@ ";
    	result += answer1 +" @@ ";
    	result += answer2 +" @@ ";
    	result += answer3 +" @@ " + correctAnswer;
    	return result;
    }
      

}
