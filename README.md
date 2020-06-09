# MarketObserver
Collection of usful tools for eve online

(!) The initial commit is NOT what is currently in production

General Idea:
- Wrap a login/logout button to the marketobserver to enable further personalized features (like mining ledger, assign alts to mains, ...)

Current state:
- Login / Logout working (with spring sessions)
- Data endpoint for data for frontend is not available in initial commit
- WebClient implementation is working (see CharacterApi_Function), also with auto-refresh of tokens, but the generated API-Client creates its own WebClient, which does not use the SSO-inforamtion. Config? Logic-issue? wrong settings for the client generator?... no idea

Biggest issue to solve:
- Use autogenerated API client to interact with the SSO from the login, so that the accesstoken gets autorefreshed if needed
- Use generated MarketApi to retrieve list of orders (only example needed, logic is already exitinng from previous version)
- Get generated http client to cache requests locally , in accorande to the header infos (i.e. 30min, ...)
- reduce existing code to the minimum to allow me to understand it :)

Nice to have:
- Beautify frontend - align frames/boxes
- Refactor frontend to have a common nav bar and allow new sub pages in the furure
- refactor to JWT?


Poke me ingame if you want collaboration rights or database credentials


ressources: 
- Resources: https://esi.evetech.net/ui/
- Create client credentials: https://developers.eveonline.com/
- swagger/openApi-infos: https://esi.evetech.net/latest/swagger.json
