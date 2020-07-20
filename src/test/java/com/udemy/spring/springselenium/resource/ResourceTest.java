package com.udemy.spring.springselenium.resource;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata.csv")
    private Resource resourceClasspath;

    @Value("classpath:data/testdata2.csv")
    private Resource resourceClasspath2;

    @Value("file:/Users/phildolganov/springBoot/spring-selenium/src/test/resources/data/testdata.csv")
    private Resource resourceFile;

    @Value("https://www.google.com")
    private Resource resourceUrl;

    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
    private Resource resourceDownload;

    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void resourceTest1() throws IOException {
        Files.readAllLines(resourceClasspath.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    public void resourceTest2() throws IOException {
        Files.readAllLines(resourceFile.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    public void resourceTest3() throws IOException {
        System.out.println(
                resourceUrl.getInputStream().toString()
        );
    }

    @Test
    public void resourceTest4() throws IOException {
        FileCopyUtils.copy(resourceDownload.getInputStream(), Files.newOutputStream(path));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resourceClasspath2.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "getData")
    public void resourceTest5(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }
}
