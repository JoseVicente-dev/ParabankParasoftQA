package co.com.sofka.page.common;


import org.apache.log4j.Logger;
import org.sikuli.script.Screen;

public class BaseSikulix {

    private static final Logger LOGGER = Logger.getLogger(BaseSikulix.class);

    public BaseSikulix(){
        //Constructor por defecto
    }

    protected void clickOn(String path){
        Screen s = new Screen();

        try {
            s.wait(path);//En la pantalla, abre la ruta, y espera un tiempo
            s.click(path);//Da click en la ruta indicada para escoger el elemento

        }catch(Exception e){
            LOGGER.warn(e.getMessage(),e);
        }
    }

    protected void insertInto(String path, String text){
        Screen s = new Screen();

        try {
            s.wait(path);
            s.write(text);

        }catch(Exception e){
            LOGGER.warn(e.getMessage(),e);
        }
    }

}
