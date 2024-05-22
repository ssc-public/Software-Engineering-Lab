به نام خدا

# بازآرایی کد (Code Refactoring)

اهداف 
آشنایی با الگوها و ابزارهای بازآرایی کد با هدف افزایش خوانایی و کارایی آن از طریق تغییر در ساختار برنامه بدون اینکه رفتار خارجی آن تغییر کند.

## نیازمندی‌ها
- حداقل یک نفر از اعضای هر گروه باید دارای یک حساب کاربری در github باشد.

## ابزارهای مورد استفاده
یک Java IDE مانند IntelliJ IDEA و یا Eclipse به همراه jdk حداقل نسخه ۸

## منابع آموزشی
- [فیلم آموزشی](https://aparat.com/v/0r5yH)
- سایت [getcodeflow.com](https://getcodeflow.com) یا [codeac.io](https://www.codeac.io/)
- [سایت refactoring.guru](https://refactoring.guru)
- [سایت sourcemaking.com](https://sourcemaking.com/)
- [پروژه MiniJava](https://github.com/ssc-public/Software-Engineering-Lab/tree/main/resources/projects/MiniJava)
- [پروژه پر از بوی بد!](https://github.com/bigsheykh/Convert_UML_to_ANSI_C)

## روال انجام آزمایش
در این آزمایش قرار است تا هفت مورد بازآرایی بر روی این پروژه انجام دهید:
- دو مورد اعمال الگوی [Facade](https://refactoring.guru/design-patterns/facade)
- یک مورد [State/Strategy](https://refactoring.guru/replace-type-code-with-state-strategy) یا [استفاده از Polymorphism به جای شرط](https://refactoring.guru/replace-conditional-with-polymorphism) 
- یک مورد [Separate Query From Modifier](https://refactoring.guru/separate-query-from-modifier)
- یک مورد [Self Encapsulated Field](https://refactoring.guru/self-encapsulate-field).
- دو مورد مختلف غیر از بازآرایی‌های مطرح‌شده در موارد بالا.
    - در [اینجا](https://refactoring.guru/refactoring/techniques) می‌توانید لیستی از تمام بازآرایی‌های موجود را ببینید.
    - بازآرایی‌های خیلی ساده مانند تغییر نام متغیرها، تغییر نوع خصیصه‌های یک کلاس (برای مثال از private به final) یا پاک‌کردن کدهای کامنت‌شده، حساب نیست.
 - بعد از بازآرایی پلاگین [formatter](https://code.revelc.net/formatter-maven-plugin/) را به فایل maven اضافه کنید.
-
به ازای هر بازآرایی، یک commit کنید و نام آن بازآرایی را هم بیاورید.

گزارش تمرین را در فایل report.md بنویسید. در این گزارش هر کدام از بازآرایی‌های انجام شده را در حد دو خط توضیح دهید.

## پرسش‌ها
علاوه بر گزارش آزمایش، پاسخ سوالات زیر را هم داخل فایل report.md بنویسید:

1. هر یک از مفاهیم زیر را در حد یک خط توضیح دهید.
    - کد تمیز
    - بدهی فنی
    - بوی بد
2. طبق دسته‌بندی وب‌سایت [refactoring.guru](https://refactoring.guru/refactoring/smells)، بوهای بد کد به پنج دسته تقسیم می‌شوند. در مورد هر کدام از این پنج دسته توضیح مختصری دهید.
3. یکی از انواع بوهای بد، Lazy Class است.
    - این بوی بد در کدام یک از دسته‌بندی‌های پنج‌گانه قرار می‌گیرد؟
    - برای برطرف‌کردن این بو، استفاده از کدام بازآرایی‌ها پیشنهاد می‌شود؟
    - در چه مواقعی باید این بو را نادیده گرفت؟
4. در وبسایت 29 بوی بد کد نامبرده شده است. سعی کنید 10 بوی بد را در [پروژه تبدیل کننده به سی](https://github.com/bigsheykh/Convert_UML_to_ANSI_C) پیدا کنید و به آن اشاره کنید.
5. در انتها بگویید پلاگین [formatter](https://code.revelc.net/formatter-maven-plugin/) چه می کند و چرا می تواند کمک کننده باشد و آیا رابطه آن با باز آرایی کد چیست؟
   

## نحوه ارسال آزمایش
آدرس مخزن پروژه خود را ارسال کنید. توجه کنید که مخزن شما عمومی (public) باشد.
