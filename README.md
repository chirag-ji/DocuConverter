# DocuConverter
[![](https://jitpack.io/v/chirag-ji/DocuConverter.svg)](https://jitpack.io/#chirag-ji/DocuConverter)


A standalone Java Library and API to convert the Microsoft Office Documents to other format very quickly.

***Note**:   This API is build on JDK 1.8 and hence it requires JRE 8 or above to run.*

## Features
- Light Weight process
- Quick Conversion
- Less fail rates


## Why I wrote this API
I faced many problem in converting files from one format to another format from, say, *DOCX* to *PDF* and to do that simple task, any one have to look to many sources to get the working code, otherwise have to use other properity software or heavy softwares to convert them. For many developers, this was the headache to code and test and so on... so to solve this problem and keeping in mind the headache of this searching, I created this API which is very handy  to use, and can be also used in your Applications too


## API Uses in your program

```java
    File inFile = new File("test/test.docx");
    File outFile = new File("test/testDocX.pdf");
    DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),
            DocumentType.DOCX, ConvertToType.PDF);
    docuConverter.setVerbose(true); //optional, only if you want the log output
    docuConverter.convertIn(new FileOutputStream(outFile));
```

Any **OutputStream** and **InputStream** can be used here,
Like to get the code in ***ByteArrayOutputStream***, we can write

```java
    File inFile = new File("test/test.docx");
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),
            DocumentType.DOCX, ConvertToType.PDF);
    docuConverter.setVerbose(true); //optional, only if you want the log output
    docuConverter.convertIn(byteArrayOutputStream);
    System.out.println(byteArrayOutputStream);
```

 ### Including API in your project
 See [Adding Dependency to project](https://jitpack.io/#chirag-ji/DocuConverter)

## Use from System Console
> Console Parameters

     -help (-h)                : Shows this message
     -input (-i, -in) <path>   : Specifies input file path
     -output (-o, -out) <path> : Specifies output file path
     -verbose (-v)             : To see intermediate processing messages.
     -version (-ver)           : View current Library Version

> Console Usage

    java -jar .\DocuConverter.jar -in < path > -out < path >  -v
    java -jar .\DocuConverter.jar -in .\test.docx -out .\test.pdf -v
    java -jar .\DocuConverter.jar -in .\test.pptx -out .\test.pdf


### Included Libraries
-  Apache POI
- Args4j
- Apache Commons Collection
- DocX4J
- iTextPDF
- And others, please see [lib folder](https://github.com/chirag-ji/DocuConverter/tree/master/lib)

## Current Supported Conversion Types
- *DOCX* to *PDF*
- *PPTX* to *PDF*
- *TXT* to *PDF*
- *PPT* to *PDF*
- *CSV* to *XML*

***Copyright © 2019 Chirag Gupta (https://github.com/chirag-ji) under MIT Licence***
