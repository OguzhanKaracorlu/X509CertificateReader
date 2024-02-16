package com.oguzhan.karacorlu.X509CertificateReader;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;
import java.nio.file.Paths;

@SpringBootApplication
public class X509CertificateReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(X509CertificateReaderApplication.class, args);
	}

	@PostConstruct
	public void findCertificateFile(){
		ApplicationHome home = new ApplicationHome(X509CertificateReaderApplication.class);
		String path = (home.getSource() == null ? "" : home.getSource().getAbsolutePath());
		// Set Certificate File Location
		File lic = new File(Paths.get(path).toFile().getParentFile().getParentFile(), "license/okaracorlu.crt");
		CertificateReader.checkLicense(lic);
	}

}
