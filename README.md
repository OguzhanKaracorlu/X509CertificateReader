# X509 Certificate Reader

## Overview

X509 Certificate Reader is a Java application designed to read X.509 certificates from a specified file location.

## Features

- Loads X.509 certificates from a file.
- Extracts and logs certificate details such as owner, issuer, start date, and expiry date.
- Simple and easy-to-use interface.

## Installation

1. Clone or download this repository to your local machine.
2. Ensure you have Java installed on your system.
3. Import the project into your preferred Java IDE.

## Usage

1. Run the `X509CertificateReaderApplication` class as a Spring Boot application.
2. The application will automatically locate the certificate file named `okaracorlu.crt` in the `license` directory relative to the application's parent directory.
3. Alternatively, you can adjust the file path in the `X509CertificateReaderApplication` class to point to a different certificate file.
4. Upon startup, the application will read the certificate file and print its details to the console.

## Dependencies

- Spring Boot
- SLF4J (Simple Logging Facade for Java)

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
