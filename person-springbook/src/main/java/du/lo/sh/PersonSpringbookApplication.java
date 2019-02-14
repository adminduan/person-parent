package du.lo.sh;

import du.lo.sh.importcls.ImportClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@Import(ImportClass.class)
public class PersonSpringbookApplication {

	@Autowired
	private ImportClass importClass;

	@PostConstruct
	public void init() {
		System.out.println(importClass + "===");
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonSpringbookApplication.class, args);
	}

}

