Feature: Employee Validation

  Scenario: Invalid FirstName
    Given User is on 'hotelBooking' Page
    When user enters invalid FirstName
    Then display 'Please fill the FirstName'

  Scenario: Invalid LastName
    Given User is on 'hotelBooking' Page
    When user enters invalid LastName
    Then display 'Please fill the LastName'

  Scenario: Invalid Email
    Given User is on 'hotelBooking' Page
    When user enters invalid Email
    Then display 'Please fill the Email'

  Scenario: Invalid MobileNo
    Given User is on 'hotelBooking' Page
    When user enters invalid MobileNo
    Then display 'Please fill the MobileNo'
    
  Scenario: Invalid Salary
    Given User is on 'hotelBooking' Page
    When user enters invalid Salary
    Then display 'Please fill the Salary'
    
  Scenario: Salary Format not corrct
    Given User is on 'hotelBooking' Page
    When user enters Salary in wrong format
    Then display 'Please provide salary in correct format'