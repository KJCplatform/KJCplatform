import platform.service.JpzlzkdwbService;
import platform.service.XzxzgzbService;
import container.ServiceProvider;


public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XzxzgzbService xzxzgzbService=(XzxzgzbService) ServiceProvider.getService(XzxzgzbService.SERVICE_NAME);
		xzxzgzbService.updateXzxzgzb(null);
	}

}
