import dev.bean.MobiliBean;
import dev.entities.Mobiliarioclinico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named (value = "mobiliController")
@RequestScoped
public class MobiliController {
    Mobiliarioclinico novoProduto = new Mobiliarioclinico(); 
    @EJB
    private MobiliBean mobiliBean;
    List<Mobiliarioclinico> productList = new ArrayList<>();
    
    public List<Mobiliarioclinico> getProductList() {
        
        productList = mobiliBean.getProducts();
        return productList;
    }
    
}
