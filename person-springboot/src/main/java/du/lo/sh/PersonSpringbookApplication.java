package du.lo.sh;

import du.lo.sh.importcls.ImportClass;
import du.lo.sh.listeners.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@Import(ImportClass.class)
public class PersonSpringbookApplication {

	@Autowired
	private ImportClass importClass;


	@Bean
	public ExitCodeGenerator exitCodeGenerator(){
		return () -> 42;


	}

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(PersonSpringbookApplication.class);
		springApplication.run(args);


		//方法一
//		SpringApplication.run(PersonSpringbookApplication.class, args);
		//方法二
//		SpringApplication springApplication = new SpringApplication(PersonSpringbookApplication.class);
//		springApplication.run(args);

		//方法三
//		SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder();
//		applicationBuilder.lazyInitialization(true).sources(PersonSpringbookApplication.class).run(args);

//		SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder();
//		applicationBuilder.listeners(new ApplicationFailedListener(), new ApplicationReadyListener(), new ApplicationStartedListener(), new ApplicationStartingEventListener(),new ApplicationRefreshListener(), new MyListener()).sources(PersonSpringbookApplication.class).run(args);

//		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder();
//		springApplicationBuilder.sources(PersonSpringbookApplication.class).run(args);
	}

}

