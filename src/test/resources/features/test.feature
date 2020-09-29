Feature: LoginFeature

  Scenario: Create an user account
    Given Shopping home page displaying
    When Click on 'Sign in' button on home page
    And Enter the email id on text box
    And Click on 'create an account' button
    And Enter the personal information for user
      | title | password | date_of_birth | address_First_name | address_Last_name | address | city  | state   | postal_code | country      | mobile     |
      | Mr    | Test123  | 03/8/2020     | lll                | sss               | 1 bis   | Paris | Alabama | 94700       | United State | 0629254828 |
    And Click on 'Register' button
    Then My account page displaying

  Scenario: User can login
    Given Shopping home page displaying
    When Click on 'Sign in' button on home page
    And Enter the User credentials
      | userID                  | password |
      | singhdinkar@outlook.com | Test123  |
    And Click on 'Sign In' button
    Then My account page displaying

  Scenario: User can add a product in the cart
    Given Shopping home page displaying
    When Click on 'Sign in' button on home page
    And Enter the User credentials
      | userID                  | password |
      | singhdinkar@outlook.com | Test123  |
    And Click on 'Sign In' button
    And Add the product in the cart
    Then Verify product added in the cart

  Scenario: Verify that user can checkout
    Given Shopping home page displaying
    When Click on 'Sign in' button on home page
    And Enter the User credentials
      | userID                  | password |
      | singhdinkar@outlook.com | Test123  |
    And Click on 'Sign In' button
    And Add the product in the cart
    And Click on checkout process button
    Then Verify that choose your payment method process displaying

  Scenario: User can see the order listed in his profile
    Given Shopping home page displaying
    When Click on 'Sign in' button on home page
    And Enter the User credentials
      | userID                  | password |
      | singhdinkar@outlook.com | Test123  |
    And Click on 'Sign In' button
    And Add the product in the cart
    And Click on checkout process button
    And Click on user profile account button
    And Click on the order list button on user profile
    Then Verify that user order list page displaying


