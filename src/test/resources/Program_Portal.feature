Feature: Testing the Program Portal WebApplication
  To test the Program Portal Application first we have
  to do signup and signIn to complete the login process and
  login to Program Portal and goes to participant page and
  perform test of adding ,deleting, updating ,and reading
  participants information.

 Background:  launching browser and login to program portal page
  and goes to the participant page.
    Given I search baseUrl in browser
    When I click on signUp url on signIn page
    And I type "vinod123@gmail.com" in the email field on to the signUp page
    And I type "123qwera" in the password field on to the signUp page
    And I click on SignUp button on to the on to the signUp page
    And I type "vinod123@gmail.com" in the email field on to the signIn page
    And I type "123qwera" in the password field on to the signIn page
    And I click on Submit button
    And I click on hamburger menu
    And I click on program management dropdown menu
    And I click on participant button
    And I selected r-d batch from dropdown menu in program management column on to participants page


@Create
  Scenario: Adding Participants to Program Portal
    When I click on add Participant Button in the program management column on participant page
    And I entered valid data on to add participant page
      | Fields        | Values              |
      | Name          | Tom Cruise          |
      | Email         | tomcruise@gmail.com |
      | Mobile Number | 8169322808          |
      | Gender        | MALE                |
      | College Name  | IIIT                |
      | Status        | ACTIVE              |
      | Is Faculty    | YES                 |

   And I click on save button on to the add participant page
    Then I verify whether "Tom Cruise" is present in program portal on the participant page

@Read
    Scenario: Reading Participants Information
   When I search "Tom Cruise" in search field on the participant page
  Then I verify UI data of "tomcruise@gmail.com" to api data


@Update
  Scenario: Updating Participants Information
    When I search "tomcruise@gmail.com" in search field on the participant page
    And I click on edit button to edit participant data
    And I entered valid data on to edit participant page
      | Fields        | Values              |
      | Name          | The Weekend         |
      | Mobile Number | 9322808816          |
      | Gender        | MALE                |
      | College Name  | IIIT                |
      | Status        | ACTIVE              |
      | Is Faculty    | NO                  |
    And I click on save button on to the edit participant page
    And I search "The Weekend" in search field on the participant page
    Then I verify UI Data of "tomcruise@gmail.com" with database data

  @Delete
  Scenario: Deleting Participants Information
    When I search "tomcruise@gmail.com" in search field on the participant page
    And I click on delete button on to the participant page
  Then I verify "The Weekend" is not present on to the participant page






#    And I search "tomcruise@gmail.com" in search field on the participant page





































































#  WHEN The user clicks the button “SAVE" in the Report Navigation Column on the Search Results page
#  THEN  the term "<query>" should be the first in the Search History grid on the My History page
#  WHEN  The user performs the Full Search with parameters: query: “fish"; city: “Murmansk"; on the Home page

#  Scenario: Adding Participants to Program Portal
#    When I click on add Participant button in the program management on participant page
#    And I entered <participant email> in participant email field
#    And I entered <participant name> in participant name field
#    And I entered <moblie number> in mobile number field
#    And I click on save button
#    And search participant data
#    Then verify whether participant present or not
#

