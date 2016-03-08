The app functions as follows:

- A single user is able to login, the user Trov/User, other users will not be able to login.
- The Trov/User is pre-populated for simplicity sake
- The server is simulated by writing to a database table called TweetServer, to better simulate a
 round trip to a real server a delay of 5 seconds is injected in writes to TweetServer.
- The tweets activity has the following features:
    - Tweets that have not been synced to the server show a sync icon next to them
    - If there is no network connection then tweets will not be synced to the server.
    - If a network connection is established while on this screen then tweets will be synced
    - Remember there is a five second delay so tweets sync five seconds after network connection is
    established.
           

Used the following libaries:
- Butterknife, as 2 way binding is the best way to go with UIs
- Dagger - nice IOC container, instances injected nicely
- SugarOrm - ORM (Objects<-->Sqlite)
- EasyMock - mock objects for unit tests
- Junit4 - latest greatest junit version

Unit Test
- Demonstrated use of mocks (i.e. expect->run->verify) and injection of mocks.


I did not spend too much time on following:
- making the UI look really nice (i.e. just used stock android controls)
- because of time constraints did not put in stuff like SwipeRefresh (i.e. pull down refresh)
- Normally I would put all strings would be in strings.xml for localization efforts