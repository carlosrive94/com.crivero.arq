import com.crivero.web.service.employees.service.EmployeeServiceWSO;
import com.crivero.web.service.products.service.ProductServiceWSO;

public class App {
	public static void main(String[] args) {
		ProductServiceWSO productServiceClient = new ProductServiceWSO();
		System.out.println(productServiceClient.getProductServiceWSOHttpSoap11Endpoint());

		EmployeeServiceWSO employeeServiceClient = new EmployeeServiceWSO();
		System.out.println(employeeServiceClient.getEmployeeServiceWSOHttpSoap11Endpoint());
	}
}