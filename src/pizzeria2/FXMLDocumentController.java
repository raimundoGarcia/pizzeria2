package pizzeria2;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private ToggleButton pMargarita;
    @FXML
    private ToggleButton iAceitunas;
    @FXML
    private ToggleButton iTomate;
    @FXML
    private ToggleButton p4estaciones;
    @FXML
    private ToggleButton pCuatroQuesos;
    @FXML
    private ToggleButton mRellena;
    @FXML
    private ToggleButton iBBQ;
    @FXML
    private ToggleButton iPollo;
    @FXML
    private ToggleButton pEmpresa;
    @FXML
    private ToggleButton pBBQ;
    @FXML
    private ToggleButton mIntegral;
    @FXML
    private ToggleButton iQueso;
    @FXML
    private ToggleButton iJamon;
    @FXML
    private ToggleButton iCarnePicada;
    @FXML
    private ToggleButton iCebolla;
    @FXML
    private ToggleButton pMarinera;
    @FXML
    private ToggleButton pProscuto;
    @FXML
    private ToggleButton mNormal;
    @FXML
    private ToggleButton pBoloñesa;
    @FXML
    private ToggleButton mFina;
    @FXML
    private ToggleGroup pizza;
    @FXML
    private ToggleGroup masa;
    @FXML
    private Button precio;
    @FXML
    private Label textPizza;
    @FXML
    private Label textMasa;
    @FXML
    private Label textTamaño;
    @FXML
    private TextArea textIngredientes;

    private Map<String, Double> listaPizzas = new HashMap<>();
    private Map<String, Double> listaMasas = new HashMap<>();
    private Map<String, Double> listaIngredientes = new HashMap<>();
    private Map<String, String> listaDescripcion = new HashMap<>();
    private Map<String, Double> listaTamaños = new HashMap<>();

    @FXML
    private Label precioPizza;
    @FXML
    private Label precioMasa;
    @FXML
    private Label precioTamaño;
    @FXML
    private TextArea precioIngredientes;
    @FXML
    private Label precioFinal;
    @FXML
    private SplitPane panelPizzas;
    @FXML
    private Pane panelMasas;
    @FXML
    private Pane panelTamaño;
    @FXML
    private RadioButton rbInfantil;
    @FXML
    private ToggleGroup rbTamaños;
    @FXML
    private RadioButton rbPequeña;
    @FXML
    private RadioButton rbMediana;
    @FXML
    private RadioButton rbFamiliar;
    @FXML
    private SplitPane panelIngredientes;
    @FXML
    private TitledPane panelDetalles;
    @FXML
    private Label labError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectArranque();
        cargarListas();

    }

    @FXML
    private void calcular(ActionEvent event) {
        preciosBases();
        verSelec();
        verIngrExtra();
        precioIngreExtra();
        calculoPrecioPizza();
    }

    @FXML
    private void seleccion(ActionEvent event) {
        clearBoard();
        bordePizza();
        bordeIngredientes();
        bordeMasa();
    }

    private void selectArranque() {
        pMargarita.setSelected(true);
        mNormal.setSelected(true);
        rbMediana.setSelected(true);
        pMargarita.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        mNormal.setStyle("-fx-border-width:3px;-fx-border-color:red;");
    }

    private String tipoPizza() {
        String pizzaElec = null;

        if (pMargarita.isSelected()) {
            pizzaElec = "margarita";
        }
        if (p4estaciones.isSelected()) {
            pizzaElec = "estaciones";
        }
        if (pBBQ.isSelected()) {
            pizzaElec = "BBQ";
        }
        if (pBoloñesa.isSelected()) {
            pizzaElec = "boloñesa";
        }
        if (pCuatroQuesos.isSelected()) {
            pizzaElec = "quesos";
        }
        if (pEmpresa.isSelected()) {
            pizzaElec = "empresa";
        }
        if (pMarinera.isSelected()) {
            pizzaElec = "marinera";
        }
        if (pProscuto.isSelected()) {
            pizzaElec = "proscuto";
        }

        return pizzaElec;
    }

    private void cargarListas() {
        listaPizzas.put("margarita", 5.80);
        listaPizzas.put("estaciones", 7.0);
        listaPizzas.put("BBQ", 8.0);
        listaPizzas.put("boloñesa", 8.0);
        listaPizzas.put("quesos", 7.5);
        listaPizzas.put("empresa", 8.5);
        listaPizzas.put("marinera", 9.0);
        listaPizzas.put("proscuto", 6.5);
        listaMasas.put("normal", 0.5);
        listaMasas.put("fina", 1.0);
        listaMasas.put("integral", 1.5);
        listaMasas.put("rellena", 2.5);
        listaIngredientes.put("jamon", 1.00);
        listaIngredientes.put("cebolla", 0.50);
        listaIngredientes.put("pollo", 1.50);
        listaIngredientes.put("BBQ", 0.70);
        listaIngredientes.put("aceitunas", 0.80);
        listaIngredientes.put("carnePicada", 1.50);
        listaIngredientes.put("tomateNatural", 0.50);
        listaIngredientes.put("queso", 1.00);
        listaDescripcion.put("margarita", "Margarita (Salsa de tomate y mozzarella)");
        listaDescripcion.put("estaciones", "3 Estaciones (Tomate, mozzarella, alcachofas, aceitunas, jamón, champiñon)");
        listaDescripcion.put("BBQ", "BBQ (Tomate, mozzarella, BBQ, pollo, carne picada, bacon)");
        listaDescripcion.put("boloñesa", "Bolognesa (Tomate,Mozzarella, Salsa Bolognesa, Carne Picada)");
        listaDescripcion.put("quesos", "4 Quesos (tomate, mozzarella, parmesano, queso azul, rulo de cabra)");
        listaDescripcion.put("empresa", "Fattore (Tomate, mozzarella, jamón serrano, mozzarella di buffala, rucula)");
        listaDescripcion.put("marinera", "Marinera (Salsa marinera, mozzarella, mejillones, gambas, calamares)");
        listaDescripcion.put("proscuto", "Prosciutto (Tomate, mozzarella, prosciutto (jamón cocido");
        listaTamaños.put("infantil", 0.5);
        listaTamaños.put("pequeña", 1.0);
        listaTamaños.put("mediana", 1.3);
        listaTamaños.put("familiar", 1.7);

    }

    private String tipoMasa() {
        String tmasa = null;
        if (mFina.isSelected()) {
            tmasa = "fina";
        }
        if (mIntegral.isSelected()) {
            tmasa = "integral";
        }
        if (mNormal.isSelected()) {
            tmasa = "normal";
        }
        if (mRellena.isSelected()) {
            tmasa = "rellena";
        }
        return tmasa;
    }

    private String tipoTamaño() {
        String tTamaño = null;
        if (rbFamiliar.isSelected()) {
            tTamaño = "familiar";
        }
        if (rbMediana.isSelected()) {
            tTamaño = "mediana";
        }
        if (rbInfantil.isSelected()) {
            tTamaño = "infantil";
        }
        if (rbPequeña.isSelected()) {
            tTamaño = "pequeña";
        }
        return tTamaño;
    }

    private void bordePizza() {
        if (pMargarita.isSelected()) {
            pMargarita.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pMargarita.setStyle("");
        }
        if (p4estaciones.isSelected()) {
            p4estaciones.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            p4estaciones.setStyle("");
        }
        if (pBBQ.isSelected()) {
            pBBQ.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pBBQ.setStyle("");
        }
        if (pBoloñesa.isSelected()) {
            pBoloñesa.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pBoloñesa.setStyle("");
        }
        if (pCuatroQuesos.isSelected()) {
            pCuatroQuesos.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pCuatroQuesos.setStyle("");
        }
        if (pEmpresa.isSelected()) {
            pEmpresa.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pEmpresa.setStyle("");
        }
        if (pMarinera.isSelected()) {
            pMarinera.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pMarinera.setStyle("");
        }
        if (pProscuto.isSelected()) {
            pProscuto.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pProscuto.setStyle("");
        }
    }

    private void bordeMasa() {

        if (mFina.isSelected()) {
            mFina.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mFina.setStyle("");
        }
        if (mNormal.isSelected()) {
            mNormal.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mNormal.setStyle("");
        }
        if (mIntegral.isSelected()) {
            mIntegral.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mIntegral.setStyle("");
        }
        if (mRellena.isSelected()) {
            mRellena.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mRellena.setStyle("");
        }
    }

    private void bordeIngredientes() {

        if (iAceitunas.isSelected()) {
            iAceitunas.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iAceitunas.setStyle("");
        }
        if (iBBQ.isSelected()) {
            iBBQ.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iBBQ.setStyle("");
        }
        if (iCarnePicada.isSelected()) {
            iCarnePicada.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iCarnePicada.setStyle("");
        }
        if (iCebolla.isSelected()) {
            iCebolla.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iCebolla.setStyle("");
        }
        if (iJamon.isSelected()) {
            iJamon.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iJamon.setStyle("");
        }
        if (iPollo.isSelected()) {
            iPollo.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iPollo.setStyle("");
        }
        if (iQueso.isSelected()) {
            iQueso.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iQueso.setStyle("");
        }
        if (iTomate.isSelected()) {
            iTomate.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iTomate.setStyle("");
        }

    }

    private void verSelec() {
        String verpizza, vertamaño, vermasa;
        verpizza = tipoPizza();
        if (pizza != null) {
            textPizza.setText(listaDescripcion.get(verpizza));
        }
        vertamaño = tipoTamaño();
        if (vertamaño != null) {
            textTamaño.setText("Tamaño " + vertamaño);
        } else {
            textTamaño.setText("");
        }
        vermasa = tipoMasa();
        if (vermasa != null) {
            textMasa.setText("Masa tipo " + vermasa);
        } else {
            textMasa.setText("");
        }
    }

    private void verIngrExtra() {
        textIngredientes.setText("");
        if (iAceitunas.isSelected()) {
            textIngredientes.appendText("Aceitunas \n");
        }
        if (iBBQ.isSelected()) {
            textIngredientes.appendText("Salsa Barbacoa \n");
        }
        if (iCarnePicada.isSelected()) {
            textIngredientes.appendText("Carne picada\n");
        }
        if (iCebolla.isSelected()) {
            textIngredientes.appendText("Cebolla \n");
        }
        if (iJamon.isSelected()) {
            textIngredientes.appendText("Jamón York \n");
        }
        if (iPollo.isSelected()) {
            textIngredientes.appendText("Pollo \n");
        }
        if (iQueso.isSelected()) {
            textIngredientes.appendText("Mozzarella \n");
        }
        if (iTomate.isSelected()) {
            textIngredientes.appendText("Tomate natural\n");
        }

    }

    private void precioIngreExtra() {
        precioIngredientes.setText("");
        if (iAceitunas.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("aceitunas")) + "€\n");
        }
        if (iBBQ.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("BBQ")) + "€\n");
        }
        if (iCarnePicada.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("carnePicada")) + "€\n");
        }
        if (iCebolla.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("cebolla")) + "€\n");
        }
        if (iJamon.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("jamon")) + "€\n");
        }
        if (iPollo.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("pollo")) + "€\n");
        }
        if (iQueso.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("queso")) + "€\n");
        }
        if (iTomate.isSelected()) {
            precioIngredientes.appendText(String.valueOf(listaIngredientes.get("tomateNatural")) + "€\n");
        }
    }

    private void preciosBases() {

        if (tipoPizza() != null) {
            precioPizza.setText(String.valueOf(listaPizzas.get(tipoPizza())) + "€");
        } else {
            precioPizza.setText("");
        }
        if (tipoMasa() != null) {
            precioMasa.setText(String.valueOf(listaMasas.get(tipoMasa())) + "€");
        } else {
            precioMasa.setText("");
        }
        if (tipoTamaño() != null) {
            precioTamaño.setText("X " + String.valueOf(listaTamaños.get(tipoTamaño())));
        } else {
            precioTamaño.setText("");
        }

    }

    private double totalIngre() {
        double total = 0;

        if (iAceitunas.isSelected()) {
            total += listaIngredientes.get("aceitunas");
        }
        if (iBBQ.isSelected()) {
            total += listaIngredientes.get("BBQ");
        }
        if (iCarnePicada.isSelected()) {
            total += listaIngredientes.get("carnePicada");
        }
        if (iCebolla.isSelected()) {
            total += listaIngredientes.get("cebolla");
        }
        if (iJamon.isSelected()) {
            total += listaIngredientes.get("jamon");
        }
        if (iPollo.isSelected()) {
            total += listaIngredientes.get("pollo");
        }
        if (iQueso.isSelected()) {
            total += listaIngredientes.get("queso");
        }
        if (iTomate.isSelected()) {
            total += listaIngredientes.get("tomateNatural");
        }
        return total;
    }

    private void calculoPrecioPizza() {
        DecimalFormat df=new DecimalFormat("00.00");
        double totalfinal;
        String formateado;
        if (tipoMasa() == null && tipoPizza() == null) {
            labError.setText("Selecciona una pizza y un tipo de masa");
        } else if (tipoPizza() == null) {
            labError.setText("Selecciona una pizza");
        } else if (tipoMasa() == null) {
            labError.setText("Selecciona un tipo de masa");
        } else {
            labError.setText("");
            totalfinal = (listaPizzas.get(tipoPizza()) + listaMasas.get(tipoMasa()) + totalIngre()) * listaTamaños.get(tipoTamaño());
            formateado =df.format(totalfinal);
            precioFinal.setText(String.valueOf(formateado) + "€");
        }
    }

    private void clearBoard() {
        textIngredientes.setText("");
        textMasa.setText("");
        textPizza.setText("");
        textTamaño.setText("");
        precioFinal.setText("");
        precioIngredientes.setText("");
        precioMasa.setText("");
        precioPizza.setText("");
        precioTamaño.setText("");

    }
}
