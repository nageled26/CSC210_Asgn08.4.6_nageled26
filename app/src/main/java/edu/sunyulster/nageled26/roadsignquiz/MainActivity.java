package edu.sunyulster.thomasol.mybmicalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int choice1;
    int choice2;
    int choice3;
    int choice4;
    int questionsAnswered;
    int questionsCorrect;
    String[] choices={"Hill Warning","No Parking","No U-Turn","Pedestrian Crossing","Right Lane Ends","Road Work","School Zone","Stop Sign","Stop Sign Ahead","Yield"};
    Button one;
    Button two;
    Button three;
    Button four;
    Button nextChoice;
    TextView correct;
    TextView result;
    ImageView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionsAnswered=0;
        questionsCorrect=0;
        one=(Button)findViewById(R.id.choiceOne);
        two=(Button)findViewById(R.id.choiceTwo);
        three=(Button)findViewById(R.id.choiceThree);
        four=(Button)findViewById(R.id.choiceFour);
        nextChoice=(Button)findViewById(R.id.button);
        question=(ImageView) findViewById(R.id.imageView);
        correct=(TextView) findViewById(R.id.correct);
        result=(TextView) findViewById(R.id.results);
        setChoices(questionsAnswered);
        setQuestion(questionsAnswered);
        one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                correct.setText(checkAnswer(questionsAnswered, one));
                disableButtons();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                correct.setText(checkAnswer(questionsAnswered, two));
                disableButtons();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                correct.setText(checkAnswer(questionsAnswered, three));
                disableButtons();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                correct.setText(checkAnswer(questionsAnswered, four));
                disableButtons();
            }
        });
        nextChoice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                if(questionsAnswered<10) {
                    setChoices(questionsAnswered);
                    setQuestion(questionsAnswered);
                }
                else if(questionsAnswered==10){
                    getResults();
                }
                else{
                    questionsAnswered=0;
                    questionsCorrect=0;
                    result.setText("");
                    setChoices(questionsAnswered);
                    setQuestion(questionsAnswered);
                }
            }
        });
    }

    public void setChoices(int index){
        enableButtons();
        correct.setText("");
        choice1 = (int) (Math.random() * 10);
        choice2 = (int) (Math.random() * 10);
        choice2Different();
        choice3 = (int) (Math.random() * 10);
        choice3Different();
        choice4 = (int) (Math.random() * 10);
        choice4Different();
        ensureChoice(index);
        one.setText(choices[choice1]);
        two.setText(choices[choice2]);
        three.setText(choices[choice3]);
        four.setText(choices[choice4]);

    }

    public void choice2Different() {
        while(choice2==choice1){
            choice2 = (int) (Math.random() * 10);
        }
    }
    public void choice3Different() {
        while(choice3==choice1||choice3==choice2){
            choice3 = (int) (Math.random() * 10);
        }
    }
    public void choice4Different() {
        while(choice4==choice1||choice4==choice2||choice4==choice3){
            choice4 = (int) (Math.random() * 10);
        }
    }
    public void ensureChoice(int index){
        if(index!=choice1&&index!=choice2&&index!=choice3&&index!=choice4){
            choice4=index;
        }
    }
    public String checkAnswer(int index,Button choice){

        questionsAnswered++;
        if(choice.getText()==choices[index]){
            questionsCorrect++;
            return "Correct!";
        }
        else {
            return "Incorrect!";
        }
    }
    public void disableButtons(){
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        nextChoice.setEnabled(true);
    }
    public void enableButtons(){
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        nextChoice.setEnabled(false);
    }
    public void setQuestion(int i){
        if(i==0){
            question.setImageResource(R.drawable.hill);
        }
        else if(i==1){
            question.setImageResource(R.drawable.noparking);
        }
        else if(i==2){
            question.setImageResource(R.drawable.nouturn);
        }
        else if(i==3){
            question.setImageResource(R.drawable.pedestriancrossing);
        }
        else if(i==4){
            question.setImageResource(R.drawable.rightlaneends);
        }
        else if(i==5){
            question.setImageResource(R.drawable.roadwork);
        }
        else if(i==6){
            question.setImageResource(R.drawable.schoolzone);
        }
        else if(i==7){
            question.setImageResource(R.drawable.stopsign);
        }
        else if(i==8){
            question.setImageResource(R.drawable.stopsignahead);
        }
        else if(i==9){
            question.setImageResource(R.drawable.yield);
        }
    }
    public void getResults(){
        question.setImageResource(R.drawable.whitebox);
        result.setText("You got "+questionsCorrect/questionsAnswered*100+" of the questions correct.");
        nextChoice.setText("Try Again");
        questionsAnswered++;
    }
}

