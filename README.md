# nuna_QA_Automation
Automation for Google Translation
1. Source, Translation languages, initial text and expected result should be taken from a separate  data file (.json, .yaml, or .xlsx), for example (but not necessarily the exact word!): 

▪ source language: German 

▪ translation language: Spanish  

▪ initial text: "Demokratien"  

▪ expected result: "Democracias" 

2. Add scenario: click swap languages button and verify the result. 

3. Add scenario: clear the input field, click "select input tool" button, select "screen keyboard" and  enter "Hi!" 
(OnScreenKeyboard class is dynamic which can take any kind of string)
