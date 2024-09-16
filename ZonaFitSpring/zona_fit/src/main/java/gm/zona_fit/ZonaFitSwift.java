package gm.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import gm.zona_fit.gui.ZonaFitForm;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class ZonaFitSwift {
    public static void main(String[] args) {
        // Modo Oscuro
        FlatDarculaLaf.setup();

        // Instanciar la fabrica de Spring
        ConfigurableApplicationContext contextSpring = new SpringApplicationBuilder(ZonaFitSwift.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);

        // Crear un objeto de Swift
        SwingUtilities.invokeLater(() -> {
            ZonaFitForm zonaFitForm = contextSpring.getBean(ZonaFitForm.class);
            zonaFitForm.setVisible(true);

        });
    }
}
