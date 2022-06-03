public class TelleTrad implements Runnable {
    Model model;

    TelleTrad(Model m) {
        model = m;
    }

    public void run(){
        try {
            while(true){

                Thread.sleep(2000);
                model.moveSnake();
            }

        } catch (Exception e) {

        }
    }
}
