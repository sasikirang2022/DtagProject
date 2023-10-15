# Created by pranghos at 10-08-2023
Feature: Option to Create New Department

  Background:
    Given user login into application with username "onecx" and password "onecx"
    Then user clicks on login button
    Then user clicks on the menu item Department Search to open the dialogue
    Then user clicks on department search button

  @P002271-4372_CreateDepartment
  Scenario: Verify User clicks on action ' + New Department', system navigates to Department details (Popup Dialogue)
    When The dialogue is initialized and by default the dialogue is opened with Basic search fields
    Then Action  + New Department icon is enabled on the Search Dialogue
    Then User clicks on action  + New Department, system navigates to Department details - Popup Dialogue