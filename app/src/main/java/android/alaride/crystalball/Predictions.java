package android.alaride.crystalball;

public class Predictions {

    private static Predictions predictions;
    private String[] answers;

    private Predictions() {
        answers = new String[] {
                "Your wishes will come true.",
                "Your wishes will never come true"
        };

    }

    public static Predictions get(){
        if(predictions == null){
            predictions = new Predictions();
        }
        return predictions;
    }
    public String getPrediction(){
        return answers[1];
    }
}
