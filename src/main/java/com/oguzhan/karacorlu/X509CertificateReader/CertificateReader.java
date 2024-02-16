package com.oguzhan.karacorlu.X509CertificateReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateReader {

    private static final Logger log = LoggerFactory.getLogger(CertificateReader.class);

    public static void checkLicense(File licenseFile) {

        try {

            if (licenseFile == null)
                throw new Exception("License file path not specified");
            if (!licenseFile.exists())
                throw new Exception("License file does not exist at the specified path");
            if (!licenseFile.isFile())
                throw new Exception("Specified path is not a file");

            // Load the certificate file
            FileInputStream fis = new FileInputStream(licenseFile);

            // Create the certificate factory
            CertificateFactory cf = CertificateFactory.getInstance("X.509");

            // Generate the certificate
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
            if (cert == null) {
                throw new Exception("No certificates found");
            }

            // Print certificate information
            log.info("Certificate Owner: " + cert.getSubjectDN());
            log.info("Certificate Signed by: " + cert.getIssuerDN());
            log.info("Certificate Start Date: " + cert.getNotBefore());
            log.info("Certificate Expiry Date: " + cert.getNotAfter());

            // Close the certificate file
            fis.close();

        } catch (Throwable e) {
            throw new RuntimeException("License check failed", e);
        }

    }

}
