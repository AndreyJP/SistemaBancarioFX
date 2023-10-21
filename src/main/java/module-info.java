module br.com.poo.sistemabancario {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    exports br.com.poo.sistemabancario.main;
    opens br.com.poo.sistemabancario.main to javafx.fxml;

    exports br.com.poo.sistemabancario.viewscontroller;
    opens br.com.poo.sistemabancario.viewscontroller to javafx.fxml;

    exports br.com.poo.sistemabancario.usuarios;
    opens br.com.poo.sistemabancario.usuarios to javafx.fxml;
    exports br.com.poo.sistemabancario.banco;
    opens br.com.poo.sistemabancario.banco to javafx.fxml;
}