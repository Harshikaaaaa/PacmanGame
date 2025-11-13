# ⚙️ Apache Maven Installation and Project Setup Guide (Windows 11)

Apache Maven is a build automation and dependency management tool for Java projects. It simplifies compiling, packaging, testing, and deploying applications by managing dependencies and project lifecycles automatically.

## Installation Steps

1. **Download Maven**  
   Go to the official Apache Maven website and download the latest binary ZIP archive:  
   https://maven.apache.org/download.cgi

2. **Extract the Archive**  
   Extract the ZIP file to a folder of your choice, for example:  
   `C:\Program Files\Apache\Maven`  
   This will create a directory such as:  
   `C:\Program Files\Apache\Maven\apache-maven-3.x.x`

3. **Set Environment Variables**  
   - Open *System Properties → Environment Variables*  
   - Under **System Variables**, click **New** and create:  
     - **Variable name:** `MAVEN_HOME`  
     - **Variable value:** `C:\Program Files\Apache\Maven\apache-maven-3.x.x`  
   - Edit the **Path** variable → click **New** → add:  
     `%MAVEN_HOME%\bin`

4. **Verify Installation**  
   Open a new Command Prompt and run:  
   ```bash
   mvn -version



To run project :
mvn clean compile
mvn exec:java
