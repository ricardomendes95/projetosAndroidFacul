import javafx.application.Application;
import javafx.stage.Stage;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;

public class index extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DateTime dataFinal = new DateTime();
        DateTime dataInicio = new DateTime("2019-08-10T02:41:03.030");

//        Minutes m = Minutes.minutesBetween(dataInicio,dataFinal);
//        System.out.println(m.getMinutes());
//        int total = m.getMinutes();
//        int dia = 0;
//        int hora = 0;
//        int min = 0;
//
//
//        while (total > 1439){
//            dia++;
//            total -=1440;
//        }
//        while (total >59){
//            hora++;
//            total-=60;
//        }
//        min = total;
//
//        System.out.println(dia + " Dias, "+hora+ " Horas e "+min+ "minutos");
        int contador = 4500;
        int seg  =  contador %60;
        int min  =  contador /60;
        int hora =  min      /60;
        min     %=  60;
        System.out.println(String.format("%02d:%02d:%02d",hora,min,seg));

    }
}
