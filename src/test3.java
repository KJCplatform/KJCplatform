import platform.service.JpzlzkdwbService;
import container.ServiceProvider;


public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JpzlzkdwbService jpzlzkdwbService=(JpzlzkdwbService) ServiceProvider.getService(JpzlzkdwbService.SERVICE_NAME);
		System.out.println(jpzlzkdwbService.findJpzlzkdwbInUseNameList().size());
	}

}
