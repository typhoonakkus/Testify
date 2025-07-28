Feature: Login Islemi
  @Smoke @regression
  Scenario Outline: Login
    Given validate login page
    When write username "<user>"
    And write password "<password>"
    And clicks on login btn
    Then user is navigate to the home page
    Examples:
      | user                   | password |
      | typhoonakkus@gmail.com | 123456   |
      | testuser@example.com   | abc123   |

  @regression
 Scenario: Create Account
    Given click Hesap Olustur button
    When enter phone number "5372591352"
    And click Kayıt Ol button
    Then validate SMSOTP window





    