BDDwithTestNG
Test automation with bdd structure using TestNG

PC ye Java kurulumu
PC ye Maven kurulumu
Intellij de Plugins den Cucumber install
maven download et , indirilen klasörü C:\Program Files\Apache\Maven\ uzantısına ekle (\apache-maven-3.x.x)
Sistem değişkenlerine JAVA_HOME ekle ( path: C:\Program Files\Java\jdk-21 )
Sistem değişkenlerine MAVEN_HOME ekle (C:\Program Files\Apache\Maven\apache-maven-3.x.x)
Sistem değişkenlerinde path değişkenine %MAVEN_HOME%\bin ekle
Projede sağ üstteki Maven ikonunda reload all maven projects tıkla.
Test run komutu : mvn clean test -DbaseURL=https://test.domain.com (CI\CD de yeni oluşan ortamı buaraya run time da alabilmek için baseURL CLI dan parametrik verdim)
Rapor için allure kurulumu gereklidir. Run komutu "allure serve target/allure-results"
Testler bu komut ile otomatik rapor generate ederek çalışır; mvn clean verify -Dtest=Runner "-Dcucumber.filter.tags=@Smoke" -DbaseURL=https://testcuzdan.junomoney.com.tr
raporu açmak için ; allure open target/allure-report