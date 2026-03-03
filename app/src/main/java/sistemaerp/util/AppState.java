package sistemaerp.util;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import sistemaerp.model.Product;

public class AppState {

   private final ObjectProperty<Product> selectedProduct =
        new SimpleObjectProperty<>();

    public ObjectProperty<Product> selectedProductProperty() {
        return selectedProduct;
    }

    public Product getSelectedProduct() {
        return selectedProduct.get();
    }

    public void setSelectedProduct(Product product) {
        selectedProduct.set(product);
    }

}
