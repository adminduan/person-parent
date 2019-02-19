package du.lo.sh;

import du.lo.sh.importcls.ImportClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
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
		System.out.println("====11111");
		//方法一
//		SpringApplication.run(PersonSpringbookApplication.class, args);
		//方法二
//		SpringApplication springApplication = new SpringApplication(PersonSpringbookApplication.class);
//		springApplication.run(args);

		//方法三
		SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder();
		applicationBuilder.lazyInitialization(true).sources(PersonSpringbookApplication.class).run(args);
	}

}

