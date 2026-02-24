package sistemaerp.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AppState {
    
    private final StringProperty selectedProduct = new SimpleStringProperty();

    public StringProperty selectedProductProperty() {
        return selectedProduct;
    }

    public String getSelectedProduct() {
        return selectedProduct.get();
    }

    public void setSelectedProduct(String value) {
        selectedProduct.set(value);
    }

}
