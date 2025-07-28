Feature: Login Islemi
  @Smoke
  Scenario Outline: Login
    Given validate login page
    When write username "<user>"
    And write password "<password>"
    And clicks on login btn
    Then user is navigate to the home page
    Examples:
      | user                   | password |
      | typhoonakkus@gmail.com | 123456   |


  @all
 Scenario: Step4_Havuzda bekleyen islem onayi
    Given click menuButton
    When click Islem Yonetimi
    And click Havuzda Bekleyenler
    Then validate Havuzda Bekleyenler page
    Given click borsa tanimi onayda bekleyen job "BORSA126"

  Scenario: Step4_Seans bekleyen islem onayi
    Given click menuButton
    When click Islem Yonetimi
    And click Havuzda Bekleyenler
    Then validate Havuzda Bekleyenler page
    Given click borsa tanimi onayda bekleyen job "2.Seans"


    