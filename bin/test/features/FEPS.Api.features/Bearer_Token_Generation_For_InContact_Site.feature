#@BearerToken_Incontact
#Feature: Generate Bearer Token For InContact Site
#
  #Scenario Outline: User should be able to generate Bearer Token for InContact Site Successfully
    #Given User should have the Incontact Bearer Token base URL
    #When User initiates post call for Bearer Token by using endpoint along with payload in "<InContact_Bearer_Payload_JsonFile>" AccessKeyId and AccessKeySecret
    #And User should get status code as "200" in response for Incontact api call
    #Then User verifies bearer token is generated and present in the response
#
    #Examples: 
      #| InContact_Bearer_Payload_JsonFile   |
      #| InContact_Bearer_Token_Payload.json |
#gradle runTest  -PtestTag="@BearerToken_Incontact" -Penv=QA  -Pplt=UI -Pbrowser=chrome -Pthreads=1
