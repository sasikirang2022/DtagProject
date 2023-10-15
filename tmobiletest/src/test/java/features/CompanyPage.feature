# Created by pranghos at 10-08-2023
Feature: Option to Create New Company

  Background:
    Given user login into application with username "onecx" and password "onecx"
    Then user clicks on login button
    Then user clicks on Search button

  @P002271-4385_CreateCompany
  Scenario: Verify User clicks on action 'Create New Company', system navigates to Company details wizard
    When The dialogue is initialized and by default the dialogue is opened with Basic search fields for company
    Then Action Create New Company icon is enabled on the Search Dialogue
    Then User clicks on action Create New Company, system navigates to Company details wizard

  @P002271-4518_SaveButtonCompanyDetailsTabFormat
  Scenario: Verify Save button feature on Company Details (tab format)
    When User clicks on Edit button Save button is visible or enabled
    Then User enters or update any details in the Fields and clicks on Save, system validates the message
    Then After clicking on Save the Edit button and Download Comp button is visible or enabled and the Edit Company Details becomes read-only




