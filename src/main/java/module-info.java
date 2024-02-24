module hr.algebra.java2.milionare.milionare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.rmi;
    //requires fscontext;
    requires java.naming;
    requires java.compiler;
    //requires fscontext;


    opens hr.algebra.java2.milionare.milionare to javafx.fxml;
    exports hr.algebra.java2.milionare.milionare;
    //exports hr.algebra.java2.milionare.milionare.jdk;
    //exports hr.algebra.java2.milionare.milionare.tool;
    //exports hr.algebra.java2.milionare.milionare; // export your main package
    exports hr.algebra.java2.milionare.rmiserver; // export the rmiserver package

}