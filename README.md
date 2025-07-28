# BDDwithTestNG
Test automation with bdd structure using TestNG

1. PC ye Java kurulumu
2. PC ye Maven kurulumu
3. Intellij de Plugins den Cucumber install
4. maven download et , indirilen klasörü C:\Program Files\Apache\Maven\ uzantısına ekle (\apache-maven-3.x.x\)
5. Sistem değişkenlerine JAVA_HOME ekle ( path: C:\Program Files\Java\jdk-21 )
6. Sistem değişkenlerine MAVEN_HOME ekle (C:\Program Files\Apache\Maven\apache-maven-3.x.x)
7. Sistem değişkenlerinde path değişkenine %MAVEN_HOME%\bin ekle
8. Projede sağ üstteki Maven ikonunda reload all maven projects tıkla.
9. Test run komutu : mvn clean test -DbaseURL=https://test.domain.com (CI\CD de yeni oluşan ortamı buaraya run time da alabilmek için baseURL CLI dan parametrik verdim)
10. Rapor için allure kurulumu gereklidir. allure download ve sonrasında allure klasörünü C:/ dizinine al ortam değişkenlerinde path e bin klasörü ile ekle
11. raporu serverde açmak için:  "allure serve target/allure-results" 
12. Raporu runtime da oluşturmak için Test Run komutu;
    mvn clean verify -Dtest=Runner "-Dcucumber.filter.tags=@Smoke" -DbaseURL=https://test.domain.com.tr
13. Otomatik generate report eden komut ile rapor target dizininde oluşutur. Raporu açmak için ;  allure open target/allure-report