# DocuConverter

A standalone Java Library and API to convert the Microsoft Office Documents to other format very quickly.
***Note**:   This API is build on JDK 1.8 and hence it requires JRE 8 to run.*

## Features
- Light Weight
- Quick Conversion
- Less fail rates


## Why I wrote this API
I faced many problem in converting files from one format to another format from, say, *DOCX* to *PDF* and to do that simple task, any one have to look to many sources to get the working code, otherwise have to use other properity software or heavy softwares to convert them. For many developers, this was the headache to code and test and so on... so to solve this problem and keeping in mind the headache of this searching, I created this API which is very handy  to use, and can be also used in your Applications too


## API Uses in your program

    File inFile = new File("test/test.docx");  
    File outFile = new File("test/testDocX.pdf");  
    DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),  
            DocumentType.DOCX, ConvertToType.PDF);  
    ((AbstractDocuConverter) docuConverter).setDebug(true); //optional, only if you want the log output
    docuConverter.convertIn(new FileOutputStream(outFile));

Any **OutputStream** and **InputStream** can be used here, 
Like to get the code in ***ByteArrayOutputStream***, we can write
 

    File inFile = new File("test/test.docx");  
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
    DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),  
            DocumentType.DOCX, ConvertToType.PDF);  
    ((AbstractDocuConverter) docuConverter).setDebug(true); //optional, only if you want the log output
    docuConverter.convertIn(byteArrayOutputStream);  
    System.out.println(byteArrayOutputStream);
 
 ### Including API in your project
 Only you have to unzip abd include the jar file from the [release](https://github.com/chirag-ji/DocuConverter/releases) tab to your project
> See
> 
> [Adding external libraries in IntelliJ Idea](https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project/#answer-1051705)
>
> [Adding external libraries in NetBeans](https://stackoverflow.com/questions/4879903/how-to-add-a-jar-in-netbeans/#answer-4879952)
> 
> [Adding external libraries in Eclipse](https://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse/#answer-3280384)


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

**Note**: Currently this API is only converting *DOCX*, *PPTX* to *PDF* and more conversions will be added soon.

***Copyright © 2019 Chirag Gupta (https://github.com/chirag-ji) under MIT Licence***
