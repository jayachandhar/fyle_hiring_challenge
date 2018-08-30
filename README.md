# fyle_hiring_challenge
Rest Service to get bank details based on ifsc code or bank name and city.

To test:<br/>
Get Bank details based on IFSC Code:<br/>
https://openbankservice.herokuapp.com/api/banks/:IFSCcode:<br/>
e.g.<br/>
https://openbankservice.herokuapp.com/api/banks/ANDB0002012<br/>

Get Bank details based on bank name and city:<br/>
https://openbankservice.herokuapp.com/api/banks/nearbybanks?bankname=:bankname:&city=:city:<br/>

e.g.<br/>
https://openbankservice.herokuapp.com/api/banks/nearbybanks?bankname=hdfc&city=bangalore<br/>

Get IFSC Code based on bank name and branch name:<br/>
https://openbankservice.herokuapp.com/api/banks/getifsc?bankname=:bankname&branchname=:branchname<br/>

e.g.<br/>
https://openbankservice.herokuapp.com/api/banks/getifsc?bankname=icici&branchname=KORMANGALA<br/>

Validate a IFSC code:<br/>
https://openbankservice.herokuapp.com/api/banks/validateifsc/:ifdcCode<br/>

e.g.<br/>
https://openbankservice.herokuapp.com/api/banks/validateifsc/ANDC0002012<br/>





