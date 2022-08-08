package com.study.elasticsearch.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class Crawling {
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver"; // Properties 설정
    public static String WEB_DRIVER_PATH = "chromedriver.exe"; // WebDriver 경로

    /*@GetMapping("/test")
    public void run() {
        String crawlingURL = "http://school.gyo6.net/gnet/209719/board/212841/197377316?page=1&searchType=S";

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // webDriver 옵션 설정.
        ChromeOptions options = new ChromeOptions();

        options.setHeadless(true);
        options.addArguments("--lang=ko");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
//        options.addArguments("window-size=1920,1080");
        options.setCapability("ignoreProtectedModeSettings", true);



        // weDriver 생성.
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(crawlingURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.findElement(By.xpath("//*[@id=\"all-scroll\"]/div/form/div[1]/article/div[3]/dl/dd/a[1]"));

    }*/

    @GetMapping("/test")
    public void NaverLogin (){
        // WebDriver 경로 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // 2. WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);



//        activateBot(driver);
        activeMiddleSchool(driver);
    }

    private void activeMiddleSchool(ChromeDriver driver) {
        try {
            // 원광 중학교
//            String url = "https://school.jbedu.kr/wonkwang/M010901/view/5198319?";
            // 구미전자공업고등학교
//            String url = "http://school.gyo6.net/gnet/209719/board/212841/197377316?page=1&searchType=S";
            // 군산 고등학교
            String url = "https://school.jbedu.kr/kunsan/M010301/view/5192810?";
            driver.get(url);


            // 페이지 로딩을 위해 최도 5초 대기
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//            String data_position = driver.findElement(By.tagName("a")).getAttribute("href");
            List<WebElement> datum = driver.findElements(By.tagName("a"));
            System.out.println("결과 시작");
            for (WebElement data : datum) {
                String fileName = data.getText();
                String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (ext.equals("pdf") || ext.equals("hwp") || fileName.contains("pdf") || fileName.contains("hwp")) {
                    String href = data.getAttribute("href");
                    System.out.println(href);
                }
            }
            System.out.println("결과 끝");

//            System.out.println("결과");
//            System.out.println(driver.findElement(By.xpath("//*[@id=\"m_mainView\"]/tbody/tr[3]/td/div/div[1]/span[1]/a")).getAttribute("href"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void activateBot(ChromeDriver driver) {
        try {
            String url = "https://www.naver.com/";
            driver.get(url);
            Thread.sleep(2000); // 3. 페이지 로딩 대기 시간

            // 4. 로그인 버튼 클릭
            WebElement element = driver.findElement(By.className("link_login"));
            element.click();

            Thread.sleep(1000);

            // ID 입력
            element = driver.findElement(By.id("id"));
            element.sendKeys("아이디입니다");

            // 비밀번호 입력
            element = driver.findElement(By.id("pw"));
            element.sendKeys("비밀번호입니다");

            // 전송
            element = driver.findElement(By.className("btn_global"));
            element.submit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close(); // 5. 브라우저 종료
        }
    }
}
