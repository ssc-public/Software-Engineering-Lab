به نام خدا

# مثالی از تبدیل نیازمندی‌ها به موارد آزمون با استفاده از روش ایجاد مبتنی بر رفتار (BDD)

## سناریو: جمع دو عدد

### مراحل انجام کار در محیط IntelliJ:
1. ایجاد پروژه جدید Maven در Intellij:

![image](https://user-images.githubusercontent.com/45389673/225746184-0c0c8217-734e-4cad-ac55-14fa405dd80f.png)

![image](https://user-images.githubusercontent.com/45389673/225748244-3675d5f3-8eb7-44bd-9035-3575463b8fc9.png)

![image](https://user-images.githubusercontent.com/45389673/225748256-d4f18f91-9f65-4240-a4bc-f0ebac48bb48.png)

2. افزودن dependencyهای موردنیاز شامل  JUnitو Cucumber به فایل pom.xml پروژه:
```xml
<dependencies>
        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>1.2.5</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>1.2.5</version>
            <scope>test</scope>
        </dependency>
</dependencies>
```

![image](https://user-images.githubusercontent.com/45389673/225748299-b36c14b6-f9d8-44e1-b033-cf798465ea67.png)

3. اجرای Maven->Test از طریق navigation bar سمت راست صفحه و اطمینان از انجام موفق آن با دیدن پیغام BUILD SUCCESS. (در این زمان برای دانلود dependencyها نیاز به اینترنت است و در صورتی که ارتباط برقرار نباشد با خطا مواجه می‌شود).

![image](https://user-images.githubusercontent.com/45389673/225748363-720b4f28-6e86-42c0-9088-e90f185e6384.png)

4. زدن گزینه‌های Import Changes و Enable Auto-Import از پیغام گوشه سمت راست پایین صفحه جهت Maven projects need to be imported
5. با انجام این مراحل، ملزومات راه‌اندازی می‌شود:

![image](https://user-images.githubusercontent.com/45389673/225748396-7f1d080f-4af5-4126-93b1-106748a668e1.png)

6. ایجاد یک پکیج جدید به نام resources در پکیج test پروژه و راست کلیک بر روی آن و انتخاب Mark Directory as Test Resource Root

![image](https://user-images.githubusercontent.com/45389673/225748421-c76bbccc-1df4-4f08-9b15-b297bcaf38a7.png)

![image](https://user-images.githubusercontent.com/45389673/225748445-a57bc101-4a80-462b-8a1e-1ca62d1a5bc0.png)

![image](https://user-images.githubusercontent.com/45389673/225748481-0385b889-15d2-4667-b6ea-8083abd84954.png)

7. ایجاد پکیج جدید با نام calculator در مسیر src->main->java و ایجاد دایرکتوری جدید با نام features در مسیر test->resources

![image](https://user-images.githubusercontent.com/45389673/225748500-bb05fab8-5adc-4949-9d32-9e947acc9cec.png)

![image](https://user-images.githubusercontent.com/45389673/225748513-93e4e2f8-14b1-4dba-b84a-815640803140.png)

8. ایجاد فایل جدید با عنوان calculator.feature در زیر دایرکتوری feature و نوشتن سناریوی جمع دو عدد در آن

![image](https://user-images.githubusercontent.com/45389673/225748547-d3cb4a67-3607-4c2e-b79d-dce0294ab026.png)

خطوط زیر به عنوان سناریوی جمع در این فایل نوشته می‌شوند:

```Java
@tag
Feature: Calculator 

Scenario: add two numbers
			    Given Two input values, 1 and 2
			    When I add the two values
			    Then I expect the result 3
```

![image](https://user-images.githubusercontent.com/45389673/225749456-a417a55b-51f5-4ca4-8bf6-5fd56ef3a461.png)

زبان نوشتن featureها Gherkin است که باید توسط cucumber ترجمه و اجرا شود. با ذخیره فایل، برخی از خطوط به رنگ زرد درمی­آیند زیرا مشخص نیست باید چطور تفسیر شوند. برای حل این مشکل، به انتهای هر یک از خطوط Given، When و Then رفته و کلید Alt+Enter را می­زنیم تا یک فایل جهت تعیین مراحل و stepهای اجرای سناریو ایجاد شود. قبل از این کار یک دایرکتوری با نام calculator در مسیر test->java ایجاد می­کنیم تا در آن ساخته شود:

![image](https://user-images.githubusercontent.com/45389673/225749563-bc285281-dce7-435c-a861-ffbab050c313.png)

![image](https://user-images.githubusercontent.com/45389673/225749551-ac054812-9440-4b4a-9cfd-3f768803b6ee.png)

متدهای بدون بدنه به صورت زیر در فایل MyStepdefs ایجاد می‌شوند:

```Java
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @Given("^Two input values, (\\d+) and (\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
    }


    @When("^I add the two values$")
    public void iAddTheTwoValues() {
    }

    @Then("^I expect the result (\\d+)$")
    public void iExpectTheResult(int arg0) {
    }
}
```

حال لازم است بدنه این متدها به‌صورتی که موردنظر است پیاده‌سازی شود؛ ابتدا Given، When، Then و درنهایت Before:

```Java
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (\\d+) and (\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }


    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
        System.out.print(result);
    }

    @Then("^I expect the result (\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);

    }
}
```

با ذخیره این فایل، برخی فایل­های پروژه به error compile برمی­خورند؛ زیرا Calculator هنوز تعریف نشده است. این کلاس باید پس از ایجاد دایرکتوری calculator، در مسیر زیر ساخته شود:
 src->main->java->calculator 

![image](https://user-images.githubusercontent.com/45389673/225749879-c3f79d5a-e6ca-4b65-b008-05afb314452e.png)

```Java
package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

9. زدن گزینه Maven test که در این صورت به ERROR برمی­خوریم:

![image](https://user-images.githubusercontent.com/45389673/225749942-a0d97027-9a88-4e53-b4b6-e749e0f8b543.png)

برای رفع این خطا لازم است نسخه بالاتر از Maven را در فایل pom.xml معرفی کنیم. بنابراین خطوط زیر را پس از پایان dependencies به این فایل اضافه می‌کنیم:

```xml
<properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

![image](https://user-images.githubusercontent.com/45389673/225750098-99b3ec84-9deb-4880-97d3-66af555d913f.png)

مجدداً Maven test را می­زنیم تا این بار SUCCESS شود:

![image](https://user-images.githubusercontent.com/45389673/225750121-daa01716-49b2-4288-b66d-a79e0af4714f.png)


10. بر روی فایل calculator.feature کلیک راست کرده و گزینه Run را انتخاب می­کنیم تا سناریوی این feature اجرا شود:

![image](https://user-images.githubusercontent.com/45389673/225750151-33ae11e3-03d9-4567-8cc8-1272afbdcd5a.png)

نتیجه اجرا باید به­صورت زیر باشد که نشان می­دهد یک سناریو با موفقیت تست شده است:

![image](https://user-images.githubusercontent.com/45389673/225750184-3cc0cc14-9657-498a-b213-36893c750d6c.png)


11. برای مشاهده جزئیات اجرا از طریق JUnit به این صورت عمل می­کنیم که یک کلاس جدید به نام RunnerTest.java در مسیر test->java->calculator (کنار فایل MyStepdefs) ایجاد می­نماییم و بدنه آن را به­صورت زیر پر می­کنیم که بالای سر امضای متد، عبارت زیر را قرار می­دهیم:
```Java
@RunWith(Cucumber.class)
```
![image](https://user-images.githubusercontent.com/45389673/225750264-353eaa03-004f-4244-9d0a-76d6be5e09a4.png)

با زدن فلش سبزرنگ کنار نام کلاس، این فایل اجرا می­شود ولی این بار به یک خطای جدید برمی­خورد:

![image](https://user-images.githubusercontent.com/45389673/225750283-3d0855d4-083f-494c-98c9-8b4d3a198129.png)

![image](https://user-images.githubusercontent.com/45389673/225750308-a7bacfed-acfd-45c1-968f-8aa377014db6.png)

این خطا نشان می­دهد که فایل feature را نمی­تواند پیدا کند. برای رفع آن باید مسیر این فایل را در ابتدای کلاس RunnerTest با کمک @CucumberOptions مشخص کنیم:
```Java
@CucumberOptions(features = "src/test/resources/features")
```

![image](https://user-images.githubusercontent.com/45389673/225750413-c3167441-2c23-495d-8921-9f371352f291.png)

12. با اجرای مجدد RunnerTest، خروجی به صورت زیر نمایش داده می­شود:

![image](https://user-images.githubusercontent.com/45389673/225750463-6bf024d9-9eff-464a-9221-db7e881e3797.png)

13. با تغییر مقادیر فایل feature و اعداد می­توان نتیجه تست را مشاهده کرد:

![image](https://user-images.githubusercontent.com/45389673/225750556-23940da2-a489-48d3-9f9e-3814db173759.png)

![image](https://user-images.githubusercontent.com/45389673/225750531-75e988a6-8b33-4ba8-9100-198358f29857.png)

حال نوبت به تعریف نوع دیگری از سناریو به نام scenario outline است که آن را در ادامه فایل feature به صورت زیر تعریف می‌کنیم:

```
Scenario Outline: add two numbers
    Given Two input values, <first> and <second>
    When I add the two values
    Then I expect the result <result>
 
  Examples:
    | first | second | result |
    | 1     | 12     | 13     |
    | -1    | 6      | 5  	    |	
    | 2     | 2      | 4	    |
```

حال RunnerTest را دوباره اجرا می­کنیم. این بار برخی تست­ها به مشکل undefined برمی­خورند. این موارد تست کدامند؟ علت بروز مشکل چیست؟ 







